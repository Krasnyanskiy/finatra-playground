package il.goldberg.finatra.playground.dao

import il.goldberg.finatra.playground.model.{Account, User}

/**
  * @author Alexander Krasniansky
  */
trait MongoDAO {

  def user(id: Long): User
  def user(name: String): User

  def account (id: Long): Account
  def accounts(range: Range): Seq[Account]

}
