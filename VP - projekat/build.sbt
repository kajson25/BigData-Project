name := "kafka-udemy-producer"
version := "0.1"
scalaVersion := "2.12.15"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "3.1.0",
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "org.slf4j" % "slf4j-simple" % "1.7.32"
)
