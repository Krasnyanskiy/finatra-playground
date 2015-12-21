package il.goldberg.finatra.playground.web.controller

import java.io.File
import javax.inject.Inject

import com.github.racc.tscg.TypesafeConfig
import com.twitter.finagle.httpx.Request
import com.twitter.finatra.annotations.Flag
import com.twitter.finatra.http.Controller

/**
  * Controller for the application’s static resources such
  * as JavaScript, CSS and images.
  *
  * @author Arri Goldberg
  */
class AssetsController @Inject()(
  @TypesafeConfig("app.assets.path") assertsPath: String
) extends Controller {

  get("/public/:*") {
    req: Request => {
      req.params.get("*") match {
        case Some(fn) =>
          response.ok.file(new File(assertsPath + fn))
        case None => {
          response.notFound("Oh no!")
        }
      }
    }
  }

}
