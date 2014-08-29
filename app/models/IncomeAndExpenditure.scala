package models

import java.sql.Timestamp

/**
 * Created by tsuiki_kenji on 2014/08/29.
 */
case class IncomeAndExpenditure(
  var title_id: Long, var targetDate: Timestamp, var expenditure: Long, var income: Long, var note: String, var iae_order: Long)
  extends BaseEntity with CreationTimeMonitoring {

  def this() = this(0, new Timestamp(System.currentTimeMillis), 0, 0, "", 0)

}
