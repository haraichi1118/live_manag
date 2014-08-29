package models

/**
 * Created by tsuiki_kenji on 2014/08/28.
 */
case class Expense(var title_id: Long, var item_name: String, var price: Long, var ex_check: Long, var ex_order:Long)
  extends BaseEntity with CreationTimeMonitoring {

  def this() = this(0, "", 0, 0, 0)

}
