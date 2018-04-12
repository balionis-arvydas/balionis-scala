package com.balionis.scala1

import org.slf4j.LoggerFactory

class MyApp(val service : MyService) {

  val LOGGER = LoggerFactory.getLogger(getClass)

  def echo(msg : String) : String = {
    LOGGER.debug("echo: msg={}", msg)
    service.echo(msg)
  }

}

object MyApp extends App {

  val LOGGER = LoggerFactory.getLogger(getClass)

  LOGGER.debug("MyApp: args={}", args mkString ", ")

  val app : MyApp = new MyApp(MyService.newService(args(0)))

  val res = app.echo(args(1))

  LOGGER.debug("MyApp: app={}", res)

  println("res=" + res)
}
