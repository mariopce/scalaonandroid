package com.fortysevendeg.scala.android

/**
  * Created by mario on 03.05.16.
  */
//tag::scalatoasts[]
trait ScalaToasts {
  //implicit conversion String=> Toast
 implicit def asToastable(str: String): Toastable = {
   new Toastable(str)
 }
}
//end::scalatoasts[]
