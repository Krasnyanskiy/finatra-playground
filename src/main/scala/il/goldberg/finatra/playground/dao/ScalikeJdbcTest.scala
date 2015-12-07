package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.dao.CustomerDAO

/**
  * @author Alexander Krasniansky
  */
object ScalikeJdbcTest extends App {

  val dao = new CustomerDAO
  val customer = dao.findById(2)

  customer match {
    case c => println(c)
    case None =>
  }

}
