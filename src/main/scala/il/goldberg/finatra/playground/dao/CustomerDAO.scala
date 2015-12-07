package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.model.Customer

import scalikejdbc._
import scalikejdbc.config._

/**
  * @author Arri Goldberg
  */
class CustomerDAO {

  DBs.setupAll()

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
