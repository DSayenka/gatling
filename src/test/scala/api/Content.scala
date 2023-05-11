package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Content {
  def GETcontent(): ChainBuilder = {
    exec(
      http("GETcontent")
        .get(baseURL + apiURL + s"/content/pages/?page=0&count=20&store=DEFAULT&lang=en")
        .check(jsonPath(path = "$.totalPages").is(expected = "0"))
        .check(status.is(200))
    )
  }
}
