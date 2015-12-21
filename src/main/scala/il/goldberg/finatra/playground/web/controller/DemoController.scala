package il.goldberg.finatra.playground.web.controller

import javax.inject.{Singleton, Inject}

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller
import il.goldberg.finatra.playground.dao.CustomerDAO
import il.goldberg.finatra.playground.domain.{Customer, DummyModel, Info}
import org.joda.time.DateTime

import scala.util.{Success, Failure}

/**
  * @author Arri Goldberg
  */
@Singleton
class DemoController @Inject()(customerDAO: CustomerDAO) extends Controller {

  // ::: GET :::

  get("/") {
    request: Request => "Hello"
  }

  get("/user/:name/age/:age") {
    req: Request => {
      response.ok("Nice!").html("<h1>OloloCaptain</h1>")
    }
  }

  get("/customer/:id") {
    req: Request => {
      val id: Long = req.params.getLong("id").getOrElse(-1)
      customerDAO.findById {
        id
      } match {
        case Some(c@Customer(_,_,_)) =>
          response.ok.body(c)
        case None =>
          response.ok.html(s"<h1>There is no customer with id $id<h1>")
      }
    }
  }

  get("/test/new") {
    request: Request => {
      DummyModel(1, "Ololo", new DateTime)
    }
  }

  // ::: POST :::

  post("/test") {
    model: Info => {
      model.content.toStdout()
      model.copy(model.id + 1, model.content)
    }
  }

  post("/test/new") {
    model: DummyModel => {
      model
    }
  }

}
