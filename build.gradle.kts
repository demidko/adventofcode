repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.6.0"
  id("com.github.johnrengelman.shadow") version "7.1.0"
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.jar {
  isZip64 = true
  manifest.attributes("Main-Class" to "com.adventofcode.year2021.AppKt")
}
tasks.shadowJar {
  minimize()
}
tasks.build {
  dependsOn(tasks.shadowJar)
}
