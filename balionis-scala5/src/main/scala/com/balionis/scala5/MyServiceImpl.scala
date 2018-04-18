package com.balionis.scala5

import com.google.inject.Inject
import com.typesafe.scalalogging.LazyLogging
import com.google.inject.name.Named

class MyServiceImpl @Inject()(@Named("MyServiceName") val name:String) extends MyService with LazyLogging {

  @Override
  def echo(msg : String) : String = {

    logger.debug("echo: name={}, msg={}", name, msg)

    name + ":" + msg
  }

}