import akka.actor.{ActorSystem, Props}

object Main extends App {
  val system = ActorSystem("Main")
  val test1 = system.actorOf(Props(new ICallMyself(10)), "test1")
  test1 ! Go
  system.terminate()
}
