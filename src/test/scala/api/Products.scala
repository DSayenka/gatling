package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Products {
  def GETProducts(): ChainBuilder = {
    exec(
      http("GETProducts")
        .get(baseURL + apiURL + "/products")
        .check(status.is(200))
    )
  }

  def GETproductsProductID(product_id: String = "1"): ChainBuilder = {
    exec(
      http("GETproductsProductID")
        .get(baseURL + apiURL + s"/products/$product_id?lang=en&store=DEFAULT")
        .check(jsonPath(path = "$.id").is(expected = s"$product_id"))
        .check(status.is(200))
    )
  }

  def GETproductsProduct_idReviews(product_id: String = "1"): ChainBuilder = {
    exec(
      http("GETproductsProduct_idReviews")
        .get(baseURL + apiURL + s"/products/$product_id/reviews")
        .body(StringBody("[]")).asJson
        .check(status.is(200))
    )
  }

  def GETproductsGroupFEATURED_ITEM(): ChainBuilder = {
    exec(
      http("GETproductsGroupFEATURED_ITEM")
        .get(baseURL + apiURL + "/products/group/FEATURED_ITEM")
        .check(jsonPath(path = "$.totalPages").is(expected = "1"))
        .check(status.is(200))
    )
  }

  def POSTproductPrice(product_id: String = "1"): ChainBuilder = {
    exec(
      http("POSTproductPrice")
        .post(baseURL + apiURL + s"/product/$product_id/price/")
        .body(StringBody("""{"options":[]}""")).asJson
        .check(jsonPath(path = "$.id").is(expected = "0"))
        .check(status.is(200))
    )
  }
}
