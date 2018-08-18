package com.balionis.scala7

import java.io.PrintWriter
import java.io.File

import scala.io.Source
import com.typesafe.scalalogging.LazyLogging

class MyApp(val filename: String) extends LazyLogging {

  def run(mode: String, out: PrintWriter) = {
    logger.debug("run: filename=(), mode={}", filename, mode)

    val balls = read(mode)

    val grouped = balls.groupBy(identity).mapValues(_.size).toSeq.sortBy(x => x._2)

    grouped.foreach(x => out.println(x._1 + "," + x._2))
  }

  def parse(mode: String, columns: List[String]): List[Integer] = {
    if (MyApp.BALL_MODE == mode) {
      columns.slice(1, 6).map(x => new Integer(x))
    } else if (MyApp.LUCKY_MODE == mode) {
      columns.slice(6, 8).map(x => new Integer(x))
    } else {
      List.empty[Integer]
    }
  }

  def read(mode: String): List[Integer] = {
    val lines = Source.fromFile(filename).getLines.filter(x => !x.startsWith("#")).map(x => x.split(","))
    lines.map(x => parse(mode, x.toList)).flatten.toList
  }
}

object MyApp extends App with LazyLogging {

  val BALL_MODE = "ball"
  val LUCKY_MODE = "lucky"

  def usage() = {
    println("usage: <filename> <mode> <output>")
  }

  // main

  logger.debug("MyApp: args={}", args mkString ", ")

  if (args.length < 2) {
    usage();
    System.exit(1);
  }

  val file = args(0)
  val mode = args(1)

  val out = if (args.length > 2) {
    new PrintWriter(new File(args(2)))
  } else {
    new PrintWriter(System.out)
  }

  val app : MyApp = new MyApp(file)

  app.run(mode, out)

  out.close()

  logger.debug("MyApp:done")

}
