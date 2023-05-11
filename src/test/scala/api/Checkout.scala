package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Checkout {
  def GETzones(): ChainBuilder = {
    exec(
      http("GETzones")
        .get(baseURL + apiURL + s"/zones/?code=")
        .check(status.is(200))
    )
  }

  def GETconfig(): ChainBuilder = {
    exec(
      http("GETconfig")
        .get(baseURL + apiURL + "/config/")
        .check(status.is(200))
    )
  }

  def GETshipping(): ChainBuilder = {
    exec(
      http("GETshipping")
        .get(baseURL + apiURL + "/shipping/country")
        .check(header("Content-Type").exists)
        .check(status.is(200))
    )
  }

  def GETcart(session_id: String = ""): ChainBuilder = {
    exec(
      http("GETcart")
        .get(baseURL + apiURL + "/cart/${session_id}")
        .check(jsonPath(path = "$.code").is(expected = "${session_id}"))
        .check(status.is(200))
    )
  }

  def GETcartTotal(): ChainBuilder = {
    exec(
      http("GETcartTotal")
        .get(baseURL + apiURL + "/cart/${session_id}/total/")
        .check(status.is(200))
    )
  }
}
