package il.goldberg.finatra.playground.controller

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller
import il.goldberg.finatra.playground.model.{DummyModel, Info}
import org.joda.time.DateTime

/**
  * @author Arri Goldberg
  */

// @formatter:off

/*@Singleton*/ class DemoController /*@Inject()(
  mongoDAO: MongoDAO
)*/ extends Controller {

// @formatter:on

  // ::: GET :::

  get("/") {
    request: Request => "Hello"
  }

  get("/user/:name/age/:age") {
    req: Request => {
      //val name: String = req.getParam("name")
      //val age: Int = req.getParam("age").toInt
      //s"$name, $age".toStdout()
      response.ok("Nice!").html("<h1>OloloCaptain</h1>")
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
