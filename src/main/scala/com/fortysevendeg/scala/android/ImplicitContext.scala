package com.fortysevendeg.scala.android

import android.app.Activity

/**
  * Created by mario on 03.05.16.
  */
trait ImplicitContext  {
    this: Activity =>
      implicit val context = this
}
