package il.goldberg.finatra.playground.web.controller

import java.io.File

import com.twitter.finagle.httpx.Method.Get
import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.{RouteBuilder, Controller}
import com.twitter.finatra.response.Mustache
//import il.goldberg.finatra.playground.model.User

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

  get("/public/:*") {
    req: Request => {
      req.params.get("*") match {
        case Some(fn) =>
          response.ok.file {
            new File("/Users/akrasnyanskiy/IdeaProjects/finatra-playground/src/main/resources/public/" + fn)
          }
        case None => {
          response.notFound("Oh no!")
        }
      }
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


