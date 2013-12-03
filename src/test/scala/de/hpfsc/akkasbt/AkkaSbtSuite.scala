package de.hpfsc.akkasbt

import akka.actor.{Props, ActorSystem}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.FunSuite

class AkkaSbtSuite(_system: ActorSystem) extends TestKit(_system) with FunSuite with ImplicitSender {
  def this() = this(ActorSystem("PostponeSpec"))

  test("increasing and getting the counter") {
    val counterActor = system.actorOf(Props[Counter])

    counterActor ! GetCounter
    expectMsg(0)

    counterActor ! GetCounter
    expectMsg(0)

    counterActor ! Increase
    counterActor ! GetCounter
    expectMsg(1)

    counterActor ! GetCounter
    expectMsg(1)

    counterActor ! Increase
    counterActor ! Increase
    counterActor ! Increase
    counterActor ! Increase
    counterActor ! Increase
    counterActor ! Increase
    counterActor ! GetCounter
    expectMsg(7)
  }
}
