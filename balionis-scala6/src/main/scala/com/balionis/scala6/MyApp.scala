package com.balionis.scala6

import com.typesafe.scalalogging.LazyLogging

case class MyMsg(data: String) {
}

object MyMsg {

  implicit def toMessage(data: String) = new MyMsg(data)

}

import MyMsg._

class MyApp(val name: String) extends LazyLogging {

  def echo(msg : MyMsg) : String = {
    logger.debug("echo: name={}, msg={}", name, msg)

    (name + ":" + msg.data)
  }

}

object MyApp extends App with LazyLogging {

  logger.debug("MyApp: args={}", args mkString ", ")

  val name = if (args.length > 0 ) args(0) else "myName"
  val msg  = if (args.length > 1 ) args(1) else "myMsg"

  val app : MyApp = new MyApp(name)

  val res = app.echo(msg)

  logger.debug("MyApp: res={}", res)

  println("res=" + res)
}
