package com.balionis.scala1

import org.slf4j.LoggerFactory

class MyService(val name: String) {

  def echo(msg : String) : String = {

    MyService.LOGGER.debug("echo: name={}, msg={}, ?={}", name, msg, "?")

    name + ":" + msg
  }

}

object MyService {

  private val LOGGER = LoggerFactory.getLogger(getClass)

  def newService(name : String): MyService = {
    new MyService(name)
  }
}
