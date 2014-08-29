package models

import java.sql.Timestamp

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.PrimitiveTypeMode._

/**
 * スキーマを管理します
 * Created by tsuiki_kenji on 2014/08/26.
 */

class BaseEntity extends KeyedEntity[Long] {
  val id: Long = 0
}

trait CreationTimeMonitoring {
  val created_at: Timestamp = new Timestamp(System.currentTimeMillis)
}

object CoreSchema extends Schema {
  val LiveTitles = table[LiveTitle]("liveTitle")
  val Expenses = table[Expense]("expense")
  val IncomeAndExpenditures = table[IncomeAndExpenditure]("incomeAndExpenditure")

  on(LiveTitles)(ent => declare(
    ent.id is(autoIncremented)
  ))

  on(Expenses)(ent => declare(
    ent.id is(autoIncremented)
  ))

  on(IncomeAndExpenditures)(ent => declare(
    ent.id is(autoIncremented)
  ))

}