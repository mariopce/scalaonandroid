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

class SampleActivity extends Activity with TypedFindView with ImplicitContext with ScalaToasts {

  lazy val textHello = findView(TR.textview);


  //lazy val locationManager; //= LocationManager
  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    textHello.setText(R.string.hello_world)
    //TR - Typed Resource better R


    //Implisit convertion
    def toastConference() = "fsfs".toast

    new Toastable("mes").toast

    toastMyName("fdsfds")


  }


  //Implisit params
  def toastMyName(name: String)(implicit ctx: Context) = {
    import android.widget.Toast._
    makeText(ctx, name, LENGTH_SHORT).show();
  }



}
