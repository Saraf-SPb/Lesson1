ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.8"

lazy val root = (project in file("."))
  .settings(
    name := "Lesson1"
  )

libraryDependencies += "io.circe" %% "circe-core" % "0.15.0-M1"
libraryDependencies += "io.circe" %% "circe-generic" % "0.15.0-M1"
libraryDependencies += "io.circe" %% "circe-parser" % "0.15.0-M1"