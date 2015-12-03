package il.goldberg.finatra.playground.model

import org.joda.time.DateTime

/**
  * @author Alexander Krasniansky
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
case class Account(number: Long) // * 3412-2334-3424-3444

// @formatter:on