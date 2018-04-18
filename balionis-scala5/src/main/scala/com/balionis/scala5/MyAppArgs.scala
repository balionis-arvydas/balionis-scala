package com.balionis.scala5

import org.kohsuke.args4j.Option

class MyAppArgs {

  @Option(name = "-name", usage="service name")
  var name: String = ""

  @Option(name = "-msg", usage="message")
  var msg: String = ""

  override def toString: String = "name=" + name + ", msg=" + msg
}