package controllers

import java.util.Date

import models.CoreSchema
import org.squeryl.PrimitiveTypeMode._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
 * Created by tsuiki_kenji on 2014/08/28.
 */
object LiveDetailController extends Controller {

  case class LiveDetailFormData(
    itemName: String, price: Long, targetDate: Date, expenditure: Long, income: Long, note: String)

  val liveDetailForm = Form(
    mapping(
      "itemName" -> nonEmptyText(maxLength = 10),
      "price" -> longNumber(max = 10),
      "targetDate" -> date("yyyy-MM-dd"),
      "expenditure" -> longNumber(max = 10),
      "income" -> longNumber(max = 10),
      "note" -> text(maxLength = 50)
    )(LiveDetailFormData.apply)(LiveDetailFormData.unapply)
  )

  def index(titleId: Long) = Action {
    inTransaction {
      val expenses = CoreSchema.Expenses.where(m => m.title_id === titleId).toList
      val incomeAndExpenditures = CoreSchema.IncomeAndExpenditures.where(m => m.title_id === titleId).toList
      Ok(views.html.liveDetail(expenses, incomeAndExpenditures, liveDetailForm, titleId))
    }
  }

}
