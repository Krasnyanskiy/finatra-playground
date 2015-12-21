package il.goldberg.finatra.playground.web.filter

import com.twitter.finagle.httpx.{Request => Req, Response => Resp}
import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.finatra.http.response.ResponseBuilder
import com.twitter.util.Future
import javax.inject.Inject

/**
  * @author Arri Goldberg
  */
class ForbiddenFilter @Inject()(responseBuilder: ResponseBuilder)
  extends SimpleFilter[Req, Resp] {

  def apply(req: Req, service: Service[Req, Resp]): Future[Resp] = {
    if (req.path == "/users")
      service(req)
    else
      Future.value(responseBuilder.forbidden)
  }

}
