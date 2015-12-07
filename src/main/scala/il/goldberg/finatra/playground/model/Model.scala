package il.goldberg.finatra.playground.model

import org.joda.time.DateTime
import scalikejdbc._

/**
  * @author Arri Goldberg
  */
// @formatter:off
sealed trait Model {
  def id     : Long
  def content: String
}

case class Info (
  id     : Long,
  content: String
) extends Model

case class DummyModel (
  id     : Long,
  content: String,
  date   : DateTime
) extends Model

case class User   (name  : String, age: Int)
case class Account(number: Long)

case class Customer(
  id: Long,
  firstname: String,
  lastname : String
)
object Customer extends SQLSyntaxSupport[Customer]