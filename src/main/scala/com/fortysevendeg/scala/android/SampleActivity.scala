/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.scala.android


import android.app.Activity
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener


class SampleActivity extends Activity with TypedFindView with ImplicitContext with ScalaToasts {


  lazy val makeItButton = {
    val b = findView(TR.make_it_button)
    b.setOnClickListener(new OnClickListener {
      override def onClick(v: View): Unit = {
        "Clicked".toast
        Log.d("UI", "Clicked");
      }
    })
    b
  }
  lazy val displayTextView = findView(TR.display)


  // lazy val locationManager =  LocationManager.get
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)

    //Implisit convertion
    "test1".toast
    Log.d("UI", "Clicked");
    println(makeItButton)
    //displayTextView <~ text("Hello!")
  }
}


