package il.goldberg.finatra.playground.dao

import com.twitter.util.Try
import il.goldberg.finatra.playground.dao.CustomerDAO.customerMapper
import il.goldberg.finatra.playground.model.Customer

import scalikejdbc._
import scalikejdbc.config._

/**
  * This class provides a very simple Api to work with
  * customer db representations.
  *
  * @author Arri Goldberg
  */
class CustomerDAO {

  DBs.setupAll()

  /**
    * Finds a customer by id.
    * @param id customer id
    * @param session db session
    * @return customer
    */
  def findById(id: Long)(implicit session: DBSession = Customer.autoSession) = {

    /*
       Further consideration
       ---------------------
       1. If db is unavailable than how we can handle it?
       2. Do we need to avoid stacktrace printing to stdout?
       3. Can we wrap the result in the Try monad?
     */

    //Try {
      sql"SELECT * FROM Customers WHERE id = $id".map(customerMapper).single.apply()
    //}
  }

  /**
    * Finds customers by id range.
    * @param idRange id range
    * @param session db session
    * @return customers
    */
  def findByIdRange(idRange: Range.Inclusive)(implicit session: DBSession = Customer.autoSession) = {
    sql"SELECT * FROM Customers WHERE id BETWEEN ${idRange(0)} AND ${idRange.last}".map(customerMapper).list.apply()
  }

  def save(c: Customer): Boolean = ???

  def delete(id: Customer): Boolean = ???

}

object CustomerDAO {
  def customerMapper = (rs: WrappedResultSet) => Customer(
    rs.int("id"),
    rs.string("firstname"),
    rs.string("lastname")
  )
}