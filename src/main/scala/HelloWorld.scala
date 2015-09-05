/**
 * Created by User on 30/07/2015.
 */

import com.mongodb.{DB => MongoDB, DBCollection, Mongo, BasicDBObject}
import scala.collection.convert.Wrappers._

object HelloWorld {
  def main(args: Array[String]) {
    def client =new MongoClient()
    def db=client.db("AA")
  //val col=db.r
  //  for(name<-db.collectionNames) println(name)
   // val col=db.
  }

  class MongoClient(host: String, port: Int) {
    private val underlying=new Mongo(host,port)
    def this()=this("127,0,0,0", 27017)
    def dropDB(name: String)=underlying.dropDatabase(name)
    def createDB(name: String)=DB(underlying.getDB(name))
    def db(name:String)=DB(underlying.getDB(name))
  }

  class DB private(val underlying:MongoDB) {
    private def collection(name:String)=underlying.getCollection(name)
    def readOnlyCollection(name:String)=new DBCollection(collection(name))
    def collectionNames=
      for(name<-new JSetWrapper(underlying.getCollectionNames)) yield name
    }

  object DB {
    def apply(underlying:MongoDB)=new DB(underlying)
  }
}