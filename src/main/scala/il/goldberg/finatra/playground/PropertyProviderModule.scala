package il.goldberg.finatra.playground

import com.twitter.inject.TwitterModule

/**
  * @author Arri Goldberg
  */
object PropertyProviderModule extends TwitterModule {

  val _flag = flag("foo", "", "foo")

}
