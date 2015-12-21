package il.goldberg.finatra.playground.modules

import com.github.racc.tscg.TypesafeConfigModule
import com.github.racc.tscg.TypesafeConfigModule.fromConfig
import com.twitter.inject.TwitterModule
import com.typesafe.config.ConfigFactory
import com.typesafe.config.ConfigFactory.load

/**
  * @author Arri Goldberg
  */
object ConfigModule extends TwitterModule {
  override def configure() = install(fromConfig(load))
}