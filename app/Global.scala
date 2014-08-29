import org.squeryl.{Session, SessionFactory}
import org.squeryl.adapters.{MySQLInnoDBAdapter}
import play.api.GlobalSettings
import play.api.Application
import play.api.db.DB

/**
 *
 * Created by tsuiki_kenji on 2014/08/26.
 */
object Global extends GlobalSettings {

  override def onStart(app: Application) = {
    SessionFactory.concreteFactory = Some( () => connection )
    def connection() = {
      Session.create(DB.getConnection()(app), new MySQLInnoDBAdapter)
    }
  }

}
