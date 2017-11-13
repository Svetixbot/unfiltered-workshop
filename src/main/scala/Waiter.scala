package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food}
import unfiltered.directives.Directives._
import unfiltered.directives.{Directive, data, _}

object Waiter {
  val quantity = data.as.Int named "count"
  val foodValue = data.as.String named "food"

  val maybeFood: (Option[Int], Option[String]) => Either[ApiError, Food] =
    (maybeQuantity, maybeValue) => (maybeQuantity, maybeValue) match {
      case (Some(q), Some(v)) => Right(Food(v, q))
      case _ => Left(ApiError("oops"))
    }

  val parseRequest: Directive[Any, Nothing, Either[ApiError, Food]] = for {
    maybeQuantity <- quantity
    maybeValue <- foodValue
  } yield maybeFood(maybeQuantity, maybeValue)

  val parseQuestion = {
    for {
      v <- data.as.Int named "requestId"
    } yield v match {
      case Some(value) => Right(value)
      case _ => Left(ApiError("oops"))
    }
  }
}
