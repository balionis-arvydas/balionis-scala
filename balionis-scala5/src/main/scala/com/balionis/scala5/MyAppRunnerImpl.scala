package com.balionis.scala5

import com.typesafe.scalalogging.LazyLogging
import com.google.inject.Inject

class MyAppRunnerImpl @Inject()(val service : MyService) extends MyAppRunner with LazyLogging {

  @Override
  def run(args: MyAppArgs): Int = {
    logger.debug("run: args={}", args)

    val res = service.echo(args.msg)

    logger.debug("run: res={}", res)

    // FIXME: return zero just for fun to have unit tests do something?
    return 0
  }
}