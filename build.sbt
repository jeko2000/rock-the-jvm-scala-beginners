import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.jeko2000"
ThisBuild / organizationName := "jeko2000"

lazy val root = (project in file("."))
  .settings(
    name := "rock-the-jvm-scala-beginners",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
