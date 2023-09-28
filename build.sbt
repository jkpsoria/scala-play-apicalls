name := """jkpancho-pokedex"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-slick" % "5.0.0",
    "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
    "com.h2database" % "h2" % "1.4.197",
    "org.postgresql" % "postgresql" % "42.6.0"
)
libraryDependencies += ws
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"
libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.9.2"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "3.9.2"


play.sbt.routes.RoutesKeys.routesImport += "java.util.UUID"


