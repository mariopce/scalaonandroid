package com.fortysevendeg.scala.android

import android.content.Context

/**
  * Created by mario on 03.05.16.
  */
//tag::toastable[]
class Toastable(msg: String) {
  def toast(implicit ctx: Context) = {
    import android.widget.Toast._
    makeText(ctx, msg, LENGTH_SHORT).show()
  }
}
//end::toastable[]
