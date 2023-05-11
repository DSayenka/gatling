package api

import config.BaseHelpers._
import io.gatling.core.Predef.{jsonPath, _}
import io.gatling.core.structure._
import io.gatling.http.Predef._

object AddToCart_Table {

  def AddToCart_Table(): ChainBuilder = {
    exec(
      http("AddToCart_Table")
        .post(baseURL + apiURL + s"/cart/?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"table1","quantity":1}""")).asJson
        .check(status.is(201))
        .check(jsonPath("$.code").saveAs("session_id"))
    )
  }
}
