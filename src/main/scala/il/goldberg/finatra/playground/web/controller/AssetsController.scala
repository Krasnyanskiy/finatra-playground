package il.goldberg.finatra.playground.web.controller

import java.io.File
import javax.inject.Inject

import com.twitter.finagle.httpx.Request
import com.twitter.finatra.annotations.Flag
import com.twitter.finatra.http.Controller
import il.goldberg.finatra.playground.PropertyProviderModule

/**
  * Controller for the application’s static resources such
  * as JavaScript, CSS and images.
  *
  * @author Arri Goldberg
  */
class AssetsController @Inject()(
  @Flag("foo") path: String
) extends Controller {

  private[this] val _path = "/Users/akrasnyanskiy/IdeaProjects/finatra-playground/src/main/resources/public/"

  get("/public/:*") {
    req: Request => {
      req.params.get("*") match {
        case Some(fn) =>
          println(s"PATH IS = ${path.length} \nCURRENT PATH IS = ${_path + fn}")
          response.ok.file(new File(_path + fn))
        case None => {
          response.notFound("Oh no!")
        }
      }
    }
  }

}
