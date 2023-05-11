package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Home {
  def homeShopizer(): ChainBuilder = {
    exec(
      http("homeShopizer")
        .get(baseURL + "/actuator/health/ping")
        .check(jsonPath(path = "$.status").is(expected = "UP"))
        .check(status.is(200))
    )
  }
}
