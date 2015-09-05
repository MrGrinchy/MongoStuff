/**
 * Created by User on 06/08/2015.
 */
trait Administrable extends ReadOnly {
  def drop:Unit=underlying drop
  def dropIndexes:Unit=underlying dropIndexes
}
