import com.mongodb.DBObject

/**
 * Created by User on 06/08/2015.
 */
trait Updatable extends ReadOnly {
  def -=(doc: DBObject):Unit=underlying remove doc
  def +=(doc: DBObject):Unit=underlying save doc

}
