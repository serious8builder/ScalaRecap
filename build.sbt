ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.14"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaRecap",
    libraryDependencies ++= Seq(
      "org.scalatest"              %% "scalatest"                 % "3.2.12",
    )
  )
