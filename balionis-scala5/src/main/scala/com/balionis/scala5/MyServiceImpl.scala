package com.balionis.scala5

import java.util.Objects
import com.google.inject.Inject
import com.google.inject.name.Named
import com.typesafe.scalalogging.LazyLogging

class MyServiceImpl @Inject()(@Named("MyServiceName") val name:String) extends MyService with LazyLogging {

  Objects.requireNonNull(name, "name")

  @Override
  def echo(msg : String) : String = {

    logger.debug("echo: name={}, msg={}", name, msg)

    name + ":" + msg
  }

}