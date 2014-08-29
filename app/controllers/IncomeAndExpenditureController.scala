package controllers

import controllers.LiveDetailController._
import models.{IncomeAndExpenditure, CoreSchema}
import org.squeryl.PrimitiveTypeMode._
import play.api.mvc.{Action, Controller}

/**
 * Created by tsuiki_kenji on 2014/08/28.
 */
object IncomeAndExpenditureController extends Controller {

  def create(titleId: Long) = Action { implicit request =>
    inTransaction {
      val expenses = CoreSchema.Expenses.where(m => m.title_id === titleId).toList
      val incomeAndExpenditures = CoreSchema.IncomeAndExpenditures.where(m => m.title_id === titleId).toList
      liveDetailForm.bindFromRequest.fold(
        errors => BadRequest(views.html.liveDetail(expenses, incomeAndExpenditures, errors, titleId)),
        expenseForm => {
          CoreSchema.IncomeAndExpenditures.insert(new IncomeAndExpenditure(
            titleId,
            liveDetailForm.targetDate,
            liveDetailForm.expenditure,
            liveDetailForm.income,
            liveDetailForm.note,
            0))
          Redirect(routes.LiveDetailController.index(titleId))
        }
      )

    }

  }

}
