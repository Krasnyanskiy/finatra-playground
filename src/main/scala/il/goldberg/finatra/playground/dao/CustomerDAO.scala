package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.dao.CustomerDAO.customerMapper
import il.goldberg.finatra.playground.model.Customer

import scalikejdbc._
import scalikejdbc.config._

/**
  * @author Arri Goldberg
  */
class CustomerDAO {

  DBs.setupAll()

  /**
    * Finds a customer by id.
    * @param id
    * @param session
    * @return
    */
  def findById(id: Long)(implicit session: DBSession = Customer.autoSession) = {
    sql"SELECT * FROM Customers WHERE id = $id".map(customerMapper).single.apply()
  }

  /**
    * Finds customers by id range.
    * @param idRange
    * @param session
    * @return
    */
  def findByIdRange(idRange: Range.Inclusive)(implicit session: DBSession = Customer.autoSession) = {
    sql"SELECT * FROM Customers WHERE id BETWEEN ${idRange(0)} AND ${idRange.last}".map(customerMapper).list.apply()
  }
}

object CustomerDAO {
  def customerMapper = (rs: WrappedResultSet) => Customer(
    rs.int("id"),
    rs.string("firstname"),
    rs.string("lastname")
  )
}