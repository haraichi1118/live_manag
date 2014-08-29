package controllers

import models.{LiveTitle, CoreSchema}
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import org.squeryl.PrimitiveTypeMode._

/**
 * 家計簿タイトルのコントローラー
 * Created by tsuiki_kenji on 2014/08/25.
 */
object LiveController extends Controller {

  val liveform = Form(
    "title" -> nonEmptyText
  )

  def index = Action {
    inTransaction {
      Ok(views.html.liveList(CoreSchema.LiveTitles.where( m => m.user_id === 0).toList, liveform))
    }
  }

  def create = Action { implicit request =>
    liveform.bindFromRequest.fold(
      errors => BadRequest(views.html.liveList(CoreSchema.LiveTitles.where( m => m.user_id === 0).toList, errors)),
      title => {
        inTransaction {
          CoreSchema.LiveTitles.insert(new LiveTitle(0, title))
          Redirect(routes.LiveController.index())
        }
      }
    )
  }

  def delete(id: Long) = Action {
    inTransaction {
      CoreSchema.LiveTitles.delete(id)
      Redirect(routes.LiveController.index())
    }
  }

}
