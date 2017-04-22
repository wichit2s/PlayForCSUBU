name := """PlayForTmp"""

version := "1.0-SNAPSHOT"

//lazy val root = (project in file(".")).enablePlugins(PlayJava)
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

resolvers += "mvnrepo" at "https://mvnrepository.com/artifact/"
resolvers += "central" at "http://central.maven.org/maven2/"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// https://mvnrepository.com/artifact/com.google.firebase/firebase-admin
libraryDependencies += "com.google.firebase" % "firebase-admin" % "4.1.6"

