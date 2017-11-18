scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria" % "1.3.0",
  "org.sangria-graphql" %% "sangria-spray-json" % "1.0.0",
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10",
  "org.xerial" % "sqlite-jdbc" % "3.16.1",
  "com.typesafe.slick" %% "slick" % "3.2.0",
)

