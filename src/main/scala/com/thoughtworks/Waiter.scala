package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import unfiltered.directives.Directives._
import unfiltered.directives.{Directive, data}

object Waiter {

  /**
    * 1. Check out data.as.Int named "quantity"
    * `named` is a function which gives you back directive.
    * 2. Directives have monadic behaviour.
    * Which means you can compose them together.
    * How?
    * Check out flatMap or for comprehension?
    * 3. One more challange: how to convert Option into Either? 
    * Check out pattern matching or fold function.
    * */

    
  val parseRequest: Directive[Any, Nothing, Either[ApiError, Food]] = ???

  val parseQuestion: Directive[Any, Nothing, Either[ApiError, RequestId]] = ???
}
