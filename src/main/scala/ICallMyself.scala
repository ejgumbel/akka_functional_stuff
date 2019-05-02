import akka.actor.Actor

class ICallMyself(repeatTimes: Int) extends Actor {

  def receive: Receive = {
    case Go => {
      self ! CallState(0)
    }
    case cs: CallState if cs.n < repeatTimes => {
      self ! doSomething(cs)
    }
    case cs: CallState if cs.n == repeatTimes => {
      self ! NoGo
    }
    case NoGo => println("No Go")
    case _ => println("Other")
  }

  def doSomething(x: CallState): CallState = {
    CallState(x.n + 1)
  }

}
