package com.balionis.scala4

import com.typesafe.scalalogging.LazyLogging

class MyApp(val service : MyService) extends LazyLogging {

  def echo(msg : String) : String = {
    logger.debug("echo: msg={}", msg)
    service.echo(msg)
  }

}

object MyApp extends App with LazyLogging {

  logger.debug("MyApp: args={}", args mkString ", ")

  val app : MyApp = new MyApp(MyService.newService(args(0)))

  val res = app.echo(args(1))

  logger.debug("MyApp: app={}", res)

  println("res=" + res)
}
