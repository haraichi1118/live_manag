package models

/**
 * Created by tsuiki_kenji on 2014/08/26.
 */
case class LiveTitle(var user_id: Long, var title: String) extends BaseEntity with CreationTimeMonitoring {

  def this() = this(0, "")

}
