import sbt._

object Dependencies {
  val specs2Core = "org.specs2" %% "specs2-core" % "3.8.6"
  val specs2Mock = "org.specs2" %% "specs2-mock" % "3.8.6"
  val Specs2JUnit = "org.specs2" %% "specs2-junit" % "3.8.6"

  val rootDeps = Seq(
    specs2Core % Test,
    specs2Mock % Test,
    Specs2JUnit % Test
  )
}
