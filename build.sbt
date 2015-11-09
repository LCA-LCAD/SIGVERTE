name := """play-java-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "org.hibernate" % "hibernate-core" % "4.3.5.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"
)     
