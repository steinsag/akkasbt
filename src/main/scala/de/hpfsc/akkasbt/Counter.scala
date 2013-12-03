package de.hpfsc.akkasbt

import akka.actor.{ActorLogging, Actor}

case object Increase

case object GetCounter

/**
 * Simple counter actor, which can be increased and return its value.
 *
 * Code is based on samples used by Roland Kuhn (@rolandkuhn) in the reactive programming course on Coursera.
 */
class Counter extends Actor with ActorLogging {
  private def counter(n: Int): Receive = {
    case Increase => {
      log.debug("increase called")

      context.become(counter(n + 1))
    }
    case GetCounter => {
      log.debug("get counter called: {}", n)

      sender ! n
    }
  }

  def receive = counter(0)
}
