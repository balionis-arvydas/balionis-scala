package com.balionis.scala3

import com.typesafe.scalalogging.LazyLogging

class MyService(val name: String) extends LazyLogging {

  def echo(msg : String) : String = {

    logger.debug("echo: name={}, msg={}", Array(name, msg))

    name + ":" + msg
  }

}

object MyService extends LazyLogging {

  def newService(name : String): MyService = {
    logger.debug("newService: name={}", name)
    new MyService(name)
  }
}
