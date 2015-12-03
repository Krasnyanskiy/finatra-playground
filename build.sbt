name := "finatra-playground"

version := "1.0"

scalaVersion := "2.10.4"

lazy val versions = new {
  val finatra = "2.1.0"
}


resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com",
  "Finatra Repo"  at "http://twitter.github.com/finatra"
)

libraryDependencies ++= Seq(
  //"com.twitter" %% "finatra" % "2.1.0"
  "com.twitter.finatra" %% "finatra-http"       % versions.finatra,
  "com.twitter.finatra" %% "finatra-httpclient" % versions.finatra,
  //"com.twitter.finatra" %% "finatra-slf4j"      % versions.finatra,
  "com.twitter.inject"  %% "inject-core"        % versions.finatra
)