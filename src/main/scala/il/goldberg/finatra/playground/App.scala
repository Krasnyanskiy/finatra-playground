package il.goldberg.finatra.playground

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import il.goldberg.finatra.playground.web.controller.{AssetsController, UserController, IndexController, DemoController}
import il.goldberg.finatra.playground.web.filter.ForbiddenFilter

/**
  * @author Arri Goldberg
  */
object App extends HttpServer {

  override val modules = Seq(PropertyProviderModule)

  override def defaultFinatraHttpPort = ":7755"

  override def configureHttp(router: HttpRouter) = {
    router
      //.filter[ForbiddenFilter]
      .add[DemoController]
      .add[IndexController]
      .add[UserController]
      .add[AssetsController]
  }
}