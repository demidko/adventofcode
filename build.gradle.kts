repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.6.0"
  id("com.github.johnrengelman.shadow") version "7.1.0"
}
dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
  testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
  testImplementation("io.mockk:mockk:1.12.0")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "17"
}
tasks.test {
  useJUnitPlatform()
}
tasks.jar {
  isZip64 = true
  manifest.attributes("Main-Class" to "AppKt")
}
tasks.shadowJar {
  minimize()
}
tasks.build {
  dependsOn(tasks.shadowJar)
}
