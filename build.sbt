name := "finatra-playground"

version := "1.0-Snapshot"

scalaVersion := "2.10.4"

lazy val versions = new {
  val finatra = "2.1.0"
  val scalikejdbc = "2.3.1"
  val postgresql = "9.1-901-1.jdbc4"
  val test = "2.0"
  val tsConfig = "1.3.0"
  val tsGuiceConfig = "0.0.2"
}


resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com",
  "Finatra Repo"  at "http://twitter.github.com/finatra",
  "Sonatype"      at "https://oss.sonatype.org/content/repositories/snapshots"
)


libraryDependencies ++= Seq(
  //
  // Finatra
  //
  "com.twitter.finatra" %% "finatra-http"       % versions.finatra,
  "com.twitter.finatra" %% "finatra-httpclient" % versions.finatra,
  "com.twitter.inject"  %% "inject-core"        % versions.finatra,
  //
  // Config
  //
  "com.github.racc"     % "typesafeconfig-guice"% versions.tsGuiceConfig,
  "com.typesafe"        % "config"              % versions.tsConfig,
  //
  // Jdbc
  //
  "org.scalikejdbc"     %% "scalikejdbc"        % versions.scalikejdbc,
  "org.scalikejdbc"     %% "scalikejdbc-config" % versions.scalikejdbc,
  "org.scalikejdbc"     %% "scalikejdbc-test"   % versions.scalikejdbc   % "test",
  //
  // Postgres
  //
  "postgresql"          %  "postgresql"         % versions.postgresql,
  //
  // Test
  //
  "org.scalatest"       % "scalatest_2.10"      % versions.test         %   "test"
)