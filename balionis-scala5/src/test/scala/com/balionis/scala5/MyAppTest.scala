package com.balionis.scala5

import com.google.inject.Guice
import org.junit.Test
import org.junit.Assert._
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfter

import scala.language.postfixOps
import org.scalamock.scalatest.MockFactory
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.slf4j.{Logger, LoggerFactory}

@Test
class MyAppTest {

  @Test
  def testOK() = {

    val service: MyService = new MyServiceImpl("myService")

    val actual = service.echo("myMessage")

    assertEquals("myService:myMessage", actual)
  }

}

@RunWith(classOf[JUnitRunner])
class MyAppSpec extends FlatSpec with Matchers with BeforeAndAfter with MockFactory {

  val logger: Logger = LoggerFactory.getLogger(getClass)

  before {
    logger.debug("before: nothing to setup")
  }

  after {
    logger.debug("before: nothing to clean")
  }

  "An App" should "echo" in {

    val service: MyService = new MyServiceImpl("myService")

    val actual = service.echo("myMessage")

    logger.debug("should echo: actual={}", actual)

    assertEquals("myService:myMessage", actual)

  }

  it should "mock" in {

    class MyServiceMock extends MyServiceImpl("myMock") {
    }

    val service = mock[MyServiceMock]
    (service.echo _).expects("myMessage").returning("myMock?myMessage").once()

    val runner: MyAppRunner = new MyAppRunnerImpl(service)

    val args = new MyAppArgs
    args.name = "myService"
    args.msg = "myMessage"

    val actual = runner.run(args)
    assertEquals(0, actual)  // FIXME: nothing to check since run should return "void"

  }

  it should "stub" in {

    class MyServiceStub extends MyServiceImpl("myStub") {
    }

    val service = stub[MyServiceStub]
    (service.echo _).when("myMessage").returns("myStub!myMessage")

    val runner: MyAppRunner = new MyAppRunnerImpl(service)

    val args = new MyAppArgs
    args.name = "myService"
    args.msg = "myMessage"

    val actual = runner.run(args)

    assertEquals(0, actual) // FIXME: nothing to check since run should return "void"
    (service.echo _).verify("myMessage").once()
  }

  "My Module" should "stub" in {

    class MyServiceStub extends MyServiceImpl("myStub") {
    }

    val service = stub[MyServiceStub]
    (service.echo _).when("myMessage").returns("myStub!myMessage")

    val args = new MyAppArgs
    args.name = "myService"
    args.msg = "myMessage"

    val injector = Guice.createInjector(new MyModuleTest(service, args.name))
    val runner : MyAppRunner = injector.getInstance(classOf[MyAppRunner])

    val actual = runner.run(args)

    assertEquals(0, actual)  // FIXME: nothing to check since run should return "void"
    (service.echo _).verify("myMessage").once()
  }
}
