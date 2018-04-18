package com.balionis.scala5

import com.typesafe.scalalogging.LazyLogging
import com.google.inject.Inject
import com.google.inject.Guice

trait MyAppRunner {

  def run(args: MyAppArgs) : Int

}