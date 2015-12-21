package il.goldberg.finatra.playground.web.controller

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.{RouteBuilder, Controller}
import com.twitter.finatra.response.Mustache

/**
  * @author Arri Goldberg
  */
class UserController extends Controller {

  get("/users") {
    req: Request => {
      response.ok.view("/users.mustache",
        UsersView(
          Seq[User](
            User("Joe",  "Developer"),
            User("Mike", "Plumber"),
            User("Pitt", "Accountant")
          )
        )
      )
    }
  }

  get("/users/asJson") {
    req: Request => {
      Users
    }
  }

  object Users {
    val users: Seq[User] = List(
      User("Joe",  "Developer"),
      User("Mike", "Plumber"),
      User("Pitt", "Accountant")
    )
  }

  case class User(name: String, job: String)

  @Mustache("users")
  case class UsersView(users: Seq[User])


}


