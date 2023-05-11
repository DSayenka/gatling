package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Category {
  def GETCategory(cat: String = ""): ChainBuilder = {
    exec(
      http("GETCategory")
        .get(baseURL + apiURL + "/category/")
        .check(status.is(200))
    )
  }

  def GETCategoryProductId(product_id: String = "1"): ChainBuilder = {
    exec(
      http("GETCategoryProductId")
        .get(baseURL + apiURL + s"/category/$product_id/")
        .header(name="referer", value="http://localhost/")
        .check(status.is(200))
     )
  }

  def GETCategoryProductIdManufacturers(product_id: String): ChainBuilder = {
    exec(
      http("GETCategoryProductIdManufacturers")
        .get(baseURL + apiURL + s"/category/$product_id/manufacturers/")
        .check(header("Content-Type").exists)
        .check(status.is(200))
    )
  }
}
