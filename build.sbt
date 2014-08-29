name := "liveManag"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  "org.squeryl" %% "squeryl" % "0.9.5-6",
  "mysql" % "mysql-connector-java" % "5.1.18"
)     

play.Project.playScalaSettings
