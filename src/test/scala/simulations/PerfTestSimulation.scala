package simulations

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerScenario.{scnShopizer, _}

class PerfTestSimulation extends Simulation {

  setUp(
      scnShopizer.inject(atOnceUsers(users = 100))
  ).protocols(httpProtocol)
}

//Use command below for running test
//mvn gatling:test
//mvn clean gatling:test