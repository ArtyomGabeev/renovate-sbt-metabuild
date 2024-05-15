import Dependencies.*

ThisBuild / scalaVersion     := "3.4.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "hello",
    libraryDependencies += metaLib,
    libraryDependencies += "com.agabeev" %% "root-lib" % "0.1.0"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
