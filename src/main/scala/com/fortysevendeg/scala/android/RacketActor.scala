package com.fortysevendeg.scala.android

import akka.actor.Actor.Receive
import akka.actor.{Props, ActorLogging, ActorRef}
import android.util.Log
import com.fortysevendeg.scala.android.RacketActor.{Smash, Ball}
import macroid.akka.AkkaAndroidLogger


object RacketActor {
  case object Ball
  case object Smash

  // this is a common Akka pattern: http://doc.akka.io/docs/akka/snapshot/scala/actors.html
  // IMPORTANT: notice how we use `new RacketActor` and not `Props[RacketActor]`
  // this forces ProGuard to keep the class `RacketActor`
  // you might add a ProGuard rule as well though
  def props = Props(new RacketActor)

}
class RacketActor extends AkkaAndroidLogger {

  override def receive = {
    case Ball =>
      Log.d("akka", "Ball");
    case Smash =>
      Log.d("akka", "Smash")
      context.system.shutdown()
  }

}