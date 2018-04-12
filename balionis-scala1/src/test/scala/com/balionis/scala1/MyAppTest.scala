package com.balionis.scala1

import org.junit._
import Assert._

@Test
class MyAppTest {

  @Test
  def testOK() = {

    val service: MyService = MyService.newService("myService")

    val app : MyApp = new MyApp(service)

    val actual = app.echo("myMessage")

    assertEquals("myService:myMessage", actual)
  }

}

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfter
import scala.language.postfixOps

import org.scalamock.scalatest.MockFactory

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import org.slf4j.{Logger, LoggerFactory}

@RunWith(classOf[JUnitRunner])
class MyAppSpec extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  val LOGGER = LoggerFactory.getLogger(getClass)

  before {
    LOGGER.debug("before: nothing to setup")
  }

  after {
    LOGGER.debug("before: nothing to clean")
  }

  "An App" should "echo" in {

    val service: MyService = MyService.newService("myService")

    val app : MyApp = new MyApp(service)

    val actual = app.echo("myMessage")

    LOGGER.debug("should echo: actual={}", actual)

    assertEquals("myService:myMessage", actual)

  }

  it should "mock" in {

    class MyServiceMock extends MyService("myMock") {
    }

    val service = mock[MyServiceMock]
    (service.echo _).expects("myMessage").returning("myMock?myMessage").once()

    val app: MyApp = new MyApp(service)

    val actual = app.echo("myMessage")
    assertEquals("myMock?myMessage", actual)

  }

  it should "stub" in {

    class MyServiceStub extends MyService("myStub") {
    }

    val service = stub[MyServiceStub]
    (service.echo _).when("myMessage").returns("myStub!myMessage")

    val app : MyApp = new MyApp(service)

    val actual = app.echo("myMessage")
    assertEquals("myStub!myMessage", actual)

    (service.echo _).verify("myMessage").once()
  }
}
