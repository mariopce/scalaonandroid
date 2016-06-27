import org.scalatest._

import scala.collection.mutable.ArrayBuffer


/**
  * Created by mariusz on 27/06/16.
  */

class SimpleTest extends FlatSpec with Matchers {

  "Array with six element " should " be created " in {
    val a = ArrayBuffer[Int](1);
    a += 2;
    a += (3, 4, 5, 6)
    println(a);
    assert(a.size==6);
  }

}
