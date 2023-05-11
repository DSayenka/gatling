package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object AddToCart_Chair {

  def AddToCart_Chair(): ChainBuilder = {
    exec(
      http("AddToCart_Chair")
        .put(baseURL + apiURL + "/cart/${session_id}?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"chair1","quantity":1}""")).asJson
        .check(status.is(201))
        .check(jsonPath(path = "$.code").is(expected = "${session_id}"))
    )
  }
}
