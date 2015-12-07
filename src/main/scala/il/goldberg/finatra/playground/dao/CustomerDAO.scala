package il.goldberg.finatra.playground.dao

import scalikejdbc._
import scalikejdbc.config._

/**
  * @author Arri Goldberg
  */
class CustomerDAO {

  case class Customer(id: Long, firstname: String, lastname: String)
  object Customer extends SQLSyntaxSupport[Customer]

  DBs.setupAll()

  val c = Customer.syntax("c")

  def findById(id: Long)(implicit session: DBSession = Customer.autoSession) = {
    sql"SELECT * FROM customers WHERE id = $id".map(
      rs => Customer(
        rs.int("id"),
        rs.string("firstname"),
        rs.string("lastname")
      )
    ).single.apply()
  }

}
