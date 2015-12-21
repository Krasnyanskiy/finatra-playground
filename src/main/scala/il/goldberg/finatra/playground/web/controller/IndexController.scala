package il.goldberg.finatra.playground.web.controller

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller

/**
  * @author Arri Goldberg
  */
class IndexController extends Controller {

  get("/index") {
    req: Request => {
      response.ok.view("/index.mustache", MustacheEntity)
    }
  }


  case object MustacheEntity {
    val name = "Anonymus"
  }


}
