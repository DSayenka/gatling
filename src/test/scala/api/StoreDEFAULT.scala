package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object StoreDEFAULT {
  def GETstoreDEFAULT(): ChainBuilder = {
    exec(
      http("storeDEFAULT")
        .get(baseURL + apiURL + "/store/DEFAULT")
        .check(jsonPath(path = "$.id").is(expected = "1"))
        .check(jsonPath(path = "$.name").is(expected = "Default store"))
        .check(status.is(200))
    )
  }
}
