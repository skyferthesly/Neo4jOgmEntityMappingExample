lazy val commonSettings = Seq(
  organization := "com.certilytics",
  version := "0.1",
  scalaVersion := "2.12.3"
)

val neo4jOgmCore = "org.neo4j" % "neo4j-ogm-core" % "3.1.0"
val neo4jOgmApi = "org.neo4j" % "neo4j-ogm-api" % "3.1.0"
val neo4jOgmBoltDriver = "org.neo4j" % "neo4j-ogm-bolt-driver" % "3.1.0"
val slf4jLog4j12 = "org.slf4j" % "slf4j-log4j12" % "1.7.25"
val fastClasspathScanner = "io.github.lukehutch" % "fast-classpath-scanner" % "2.18.1"
lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "ClientServicesMapper",
    libraryDependencies ++= Seq(
      neo4jOgmCore,
      neo4jOgmApi,
      neo4jOgmBoltDriver,
      slf4jLog4j12,
      fastClasspathScanner
    )
  )