package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.model.Customer
import org.scalatest.{FlatSpec, Matchers, fixture}
import scalikejdbc._
import scalikejdbc.scalatest.AutoRollback

/**
  * @author Arri Goldberg
  */
class CustomerDAOSpec extends FlatSpec with Matchers {

  val dao = new CustomerDAO


  it should "retrieve a customer by id" in {
    dao.findById(1).get should be(Customer(1, "Abraham", "Tony"))
  }


  it should "retrieve customers by id range" in {
    val customers = dao.findByIdRange(2 to 4)
    // {1}
    customers should not be List.empty
    // {2}
    customers should { contain { Customer(4, "Bob", "Finkelson") } and have length 3 }
  }

}
