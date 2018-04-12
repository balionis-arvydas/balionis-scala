name := "balionis-scala4"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0" 
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"

libraryDependencies += "org.specs2" %% "specs2-core" % "2.4.16" % "test"
libraryDependencies += "org.specs2" %% "specs2-junit" % "2.4.16" % "test"

libraryDependencies += "junit" % "junit" % "4.11" % "test"

resolvers += Resolver.mavenLocal