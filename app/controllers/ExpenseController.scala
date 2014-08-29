package controllers

import controllers.LiveDetailController._
import models.{Expense, CoreSchema}
import org.squeryl.PrimitiveTypeMode._
import play.api.mvc.{Action, Controller}

/**
 * Created by tsuiki_kenji on 2014/08/28.
 */
object ExpenseController extends Controller {

  def create(titleId: Long) = Action { implicit request =>
    inTransaction {
      val expenses = CoreSchema.Expenses.where(m => m.title_id === titleId).toList
      val incomeAndExpenditures = CoreSchema.IncomeAndExpenditures.where(m => m.title_id === titleId).toList
      
      liveDetailForm.bindFromRequest.fold(
        errors => BadRequest(views.html.liveDetail(expenses, incomeAndExpenditures, errors, titleId)),
        liveDetailForm => {
          CoreSchema.Expenses.insert(new Expense(titleId, liveDetailForm.itemName,liveDetailForm.price, 0,0))
          Redirect(routes.LiveDetailController.index(titleId))
        }
      )
    }
  }

}
