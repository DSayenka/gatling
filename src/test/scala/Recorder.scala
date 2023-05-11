import io.gatling.recorder.GatlingRecorder
import io.gatling.recorder.config.RecorderPropertiesBuilder

object Recorder extends App {

  val props = new RecorderPropertiesBuilder()
    .simulationsFolder(IDEPathHelper.mavenSourcesDirectory.toString)
    .resourcesFolder(IDEPathHelper.mavenResourcesDirectory.toString)
    .simulationPackage("myGatling[D[D[D[D[D[D[D[D[Dcom.myGatling")

  GatlingRecorder.fromMap(props.build, Some(IDEPathHelper.recorderConfigFile))
}
