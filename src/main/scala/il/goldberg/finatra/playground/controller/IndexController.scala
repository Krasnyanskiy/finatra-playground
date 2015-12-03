package il.goldberg.finatra.playground.controller

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.http.Controller

/**
  * @author Alexander Krasniansky
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
