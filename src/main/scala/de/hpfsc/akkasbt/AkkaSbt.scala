package de.hpfsc.akkasbt

import akka.actor.{ActorLogging, ActorSystem, Props, Actor}

/**
 * Simple app class for SBT to be able to execute our sample Akka actor app.
 */
object AkkaSbt extends App {
  val akkaSbtSystem = ActorSystem("AkkaSbtSystem")

  val akkaSbtActor = akkaSbtSystem.actorOf(Props[AkkaSbt])

  akkaSbtActor ! StartCounting
}

private case object StartCounting

/**
 * Starts some counting, finally gets the counter value, and shuts down the actor system.
 *
 * Code is based on samples used by Roland Kuhn (@rolandkuhn) in the reactive programming course on Coursera.
 */
private class AkkaSbt extends Actor with ActorLogging {
  val counterActor = context.actorOf(Props[Counter], "counter")

  counterActor ! Increase
  counterActor ! Increase
  counterActor ! Increase
  counterActor ! GetCounter

  def receive: Actor.Receive = {
    case count: Int => {
      log.debug("count: {}", count)

      context.system.shutdown()
    }
  }
}
