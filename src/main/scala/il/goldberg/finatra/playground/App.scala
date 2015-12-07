package il.goldberg.finatra.playground

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import il.goldberg.finatra.playground.controller.{UserController, IndexController, DemoController}

/**
  * @author Alexander Krasniansky
  */
object App extends HttpServer {

  override def defaultFinatraHttpPort = ":7755"

  override def configureHttp(router: HttpRouter) = {
    router
      .add[DemoController]
      .add[IndexController]
      .add[UserController]
  }

}
