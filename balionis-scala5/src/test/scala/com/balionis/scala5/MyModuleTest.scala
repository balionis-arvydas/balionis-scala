package com.balionis.scala5

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class MyModuleTest(val serviceMock: MyService, val serviceName: String) extends AbstractModule {

  override protected def configure(): Unit = {
    bind(classOf[String]).annotatedWith(Names.named("MyServiceName")).toInstance(serviceName)
    bind(classOf[MyService]).toInstance(serviceMock)
    bind(classOf[MyAppRunner]).to(classOf[MyAppRunnerImpl])
  }
}