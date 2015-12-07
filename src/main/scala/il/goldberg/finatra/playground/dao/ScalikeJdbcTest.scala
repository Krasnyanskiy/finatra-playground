package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.dao.CustomerDAO
import il.goldberg.finatra.playground.model.Customer

/**
  * @author Arri Goldberg
  */
object ScalikeJdbcTest extends App {

  val dao = new CustomerDAO
  val customer = dao.findById(2)

  customer match {
    case Some(c@Customer(_, _, _)) => println(c)
    case None =>
  }

}
