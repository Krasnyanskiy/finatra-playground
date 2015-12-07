package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.model.{Account, User}

/**
  * @author Arri Goldberg
  */
trait MongoDAO {

  // todo

  def user(id: Long): User
  def user(name: String): User

  def account (id: Long): Account
  def accounts(range: Range): Seq[Account]

}
