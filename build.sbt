name := """PlayForTmp"""

version := "1.0-SNAPSHOT"

//lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

resolvers += "mvnrepository" at "http://mvnrepository.com/artifact/"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
