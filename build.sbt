import Dependencies._

name := "rentarun"

version := "0.1"

val repository = ""

val allResolver = Seq(
  Resolver.mavenLocal,
  // "Freedom Repo" at s"$nexus/hoge"
)

val commonSettings = Seq(
  scalaVersion := "2.12.7",
  organization := "com.freedom.rentarun",
  libraryDependencies ++= rootDeps,
  resolvers ++= allResolver,
  scmInfo := Some(ScmInfo(
    url(repository),
    s"scm:git:$repository"
  ))
)

