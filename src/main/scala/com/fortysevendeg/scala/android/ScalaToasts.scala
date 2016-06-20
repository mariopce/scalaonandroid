package com.fortysevendeg.scala.android

/**
  * Created by mario on 03.05.16.
  */
trait ScalaToasts {
 implicit def asToastable(str: String): Toastable = {
   new Toastable(str)
 }
}
