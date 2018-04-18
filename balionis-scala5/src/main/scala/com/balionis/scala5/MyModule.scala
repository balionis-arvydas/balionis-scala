package com.balionis.scala5

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class MyModule(val args:MyAppArgs) extends AbstractModule {
  override protected def configure(): Unit = {
    bind(classOf[String]).annotatedWith(Names.named("MyServiceName")).toInstance(args.name)
    bind(classOf[MyService]).to(classOf[MyServiceImpl])
    bind(classOf[MyAppRunner]).to(classOf[MyAppRunnerImpl])
  }
}