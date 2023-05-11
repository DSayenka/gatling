package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef.{flushCookieJar, flushHttpCache}

object ShopizerScenario {
  def scnShopizer: ScenarioBuilder = {
    scenario("Order table & Chair")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group( "Open Application"){
          exec(api.Home.homeShopizer())
            .exec(api.Category.GETCategory())
            .exec(api.Content.GETcontent())
            .exec(api.StoreDEFAULT.GETstoreDEFAULT())
            .exec(api.Products.POSTproductPrice("1"))
            .exec(api.Products.POSTproductPrice("50"))
            .exec(api.Products.POSTproductPrice("51"))
            .exec(api.Products.POSTproductPrice("52"))
            .exec(api.Products.GETproductsGroupFEATURED_ITEM())
            .exec(thinkTimer())
        }
          .group("Navigate Tables"){
            exec(api.Home.homeShopizer())
              .exec(api.Category.GETCategory())
              .exec(api.Content.GETcontent())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(api.Products.GETProducts())
              .exec(thinkTimer())
          }
          .group("Open Table Product") {
            exec(api.Home.homeShopizer())
              .exec(api.Products.GETproductsProductID("1"))
              .exec(api.Products.GETproductsProductID("50"))
              .exec(api.Products.GETproductsProductID("51"))
              .exec(api.Products.GETproductsProductID("52"))
              .exec(api.Products.GETproductsProduct_idReviews("1"))
              .exec(api.Products.GETproductsProduct_idReviews("50"))
              .exec(api.Products.GETproductsProduct_idReviews("51"))
              .exec(api.Products.GETproductsProduct_idReviews("52"))
              .exec(api.Category.GETCategory())
              .exec(api.Content.GETcontent())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(api.Products.POSTproductPrice("1"))
              .exec(thinkTimer())
          }
          .group("Add Table to Cart") {
            exec(api.AddToCart_Table.AddToCart_Table())
              .exec(thinkTimer())
          }
          .randomSwitch(
            50.0 -> group("Navigate Chairs") {
            exec(api.Home.homeShopizer())
              .exec(api.Content.GETcontent())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(api.Category.GETCategory())
              .exec(api.Products.GETProducts())
              .exec(api.Products.POSTproductPrice("50"))
              .exec(api.Category.GETCategoryProductId("1"))
              .exec(api.Category.GETCategoryProductId("51"))
              .exec(api.Category.GETCategoryProductId("50"))
              .exec(api.Category.GETCategoryProductIdManufacturers("1"))
              .exec(api.Category.GETCategoryProductIdManufacturers("51"))
              .exec(api.Category.GETCategoryProductIdManufacturers("50"))
              .exec(thinkTimer())
          }
          .group("Open Random Chair") {
            exec(api.Home.homeShopizer())
              .exec(api.Category.GETCategory())
              .exec(api.Content.GETcontent())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(api.Products.POSTproductPrice("50"))
              .exec(api.Products.GETproductsProductID("50"))
              .exec(api.Products.GETproductsProduct_idReviews("50"))
              .exec(thinkTimer())
          }
          .group("Add Chair to Cart") {
             exec(api.AddToCart_Chair.AddToCart_Chair())
              .exec(thinkTimer())
          }
          )
          .randomSwitch(
            30.0 -> group("Open Cart") {
            exec(api.Home.homeShopizer())
              .exec(api.Content.GETcontent())
              .exec(api.Category.GETCategory())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(thinkTimer())
          }
          .group("Proceed To Checkout") {
            exec(api.Home.homeShopizer())
              .exec(api.Category.GETCategory())
              .exec(api.Content.GETcontent())
              .exec(api.StoreDEFAULT.GETstoreDEFAULT())
              .exec(api.Checkout.GETconfig())
              .exec(api.Checkout.GETshipping())
              .exec(api.Checkout.GETcart())
              .exec(api.Checkout.GETzones())
              .exec(thinkTimer())
          }
          )
      )
  }
}
