package com.balionis.scala5

import collection.JavaConversions._

import com.typesafe.scalalogging.LazyLogging
import com.google.inject.Guice

import org.kohsuke.args4j.CmdLineParser

object MyApp extends App with LazyLogging {

  logger.debug("MyApp: args={}", args mkString ", ")

  val parsedArgs = new MyAppArgs
  val parser = new CmdLineParser(parsedArgs)
  parser.parseArgument(args.toList)

  logger.debug("MyApp: parsedArgs={}", parsedArgs)

  val injector = Guice.createInjector(new MyModule(parsedArgs))
  val runner : MyAppRunner = injector.getInstance(classOf[MyAppRunner])

  runner.run(parsedArgs)

  logger.debug("MyApp: done")

}
