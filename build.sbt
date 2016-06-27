android.Plugin.androidBuild

// Specifying the Android target Sdk version
platformTarget in Android := "android-22"

// Application Name
name := """scala-android"""

// Application Version
version := "1.0.0"

// Scala version
scalaVersion := "2.11.8"

// Repositories for dependencies
resolvers ++= Seq(Resolver.mavenLocal,
  DefaultMavenRepository,
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.typesafeIvyRepo("snapshots"),
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.defaultLocal)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "jcenter" at "http://jcenter.bintray.com"
)


// Override the run task with the android:run
run <<= run in Android

proguardScala in Android := true

useProguard in Android := true

proguardOptions in Android ++= Seq(
  "-ignorewarnings",
  "-keep class scala.Dynamic")

// ProGuard rules for Akka
proguardOptions in Android ++= Seq(
  "-keep class akka.actor.Actor$class { *; }",
  "-keep class akka.actor.LightArrayRevolverScheduler { *; }",
  "-keep class akka.actor.LocalActorRefProvider { *; }",
  "-keep class akka.actor.CreatorFunctionConsumer { *; }",
  "-keep class akka.actor.TypedCreatorFunctionConsumer { *; }",
  "-keep class akka.dispatch.BoundedDequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.UnboundedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.UnboundedDequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.DequeBasedMessageQueueSemantics { *; }",
  "-keep class akka.dispatch.MultipleConsumerSemantics { *; }",
  "-keep class akka.actor.LocalActorRefProvider$Guardian { *; }",
  "-keep class akka.actor.LocalActorRefProvider$SystemGuardian { *; }",
  "-keep class akka.dispatch.UnboundedMailbox { *; }",
  "-keep class akka.actor.DefaultSupervisorStrategy { *; }",
  "-keep class macroid.akka.AkkaAndroidLogger { *; }",
  "-keep class akka.event.Logging$LogExt { *; }"
)


javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions += "-target:jvm-1.7"

scalacOptions in (Compile, compile) ++=
  (dependencyClasspath in Compile).value.files.map("-P:wartremover:cp:" + _.toURI.toURL)

scalacOptions in (Compile, compile) ++= Seq(
  "-P:wartremover:traverser:macroid.warts.CheckUi"
)



libraryDependencies += android.Dependencies.aar("eu.inmite.android.lib" % "android-validation-komensky" % "0.9.4")
libraryDependencies += android.Dependencies.aar("com.android.support" %  "cardview-v7" % "22.0.0")
libraryDependencies += android.Dependencies.aar("com.android.support" % "appcompat-v7" % "22.0.0")
libraryDependencies += android.Dependencies.aar("com.android.support" % "recyclerview-v7" % "22.0.0")
libraryDependencies += android.Dependencies.aar("com.google.android.gms" % "play-services-base" % "6.5.87")

//libraryDependencies += "org.scaloid" %% "scaloid" % "4.2"
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.7"

libraryDependencies ++= Seq(
  "org.apache.maven" % "maven-ant-tasks" % "2.1.3" % "test",
  "org.robolectric" % "robolectric" % "2.4" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

libraryDependencies ++= Seq(
  aar("org.macroid" %% "macroid" % "2.0.0-M4"),
  aar("org.macroid" %% "macroid-viewable" % "2.0.0-M4"),
  "org.macroid" %% "macroid-akka" % "2.0.0-M4",
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  aar("com.android.support" % "support-v4" % "23.2.0"),
  compilerPlugin("org.brianmckenna" %% "wartremover" % "0.10")
)
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"

unmanagedClasspath in Test ++= (bootClasspath in Android).value

enablePlugins(AsciidoctorPlugin)
fork in run := true