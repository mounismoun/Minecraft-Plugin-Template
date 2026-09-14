plugins {
    kotlin("jvm") version "2.3.21"
    id("xyz.jpenilla.run-paper") version "3.0.2"
}

group = "io.github.mounismoun"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.123-stable")
}

kotlin {
    jvmToolchain(25)
}

tasks.runServer {
    minecraftVersion("26.2")
    build(123)
    runDirectory.set(layout.projectDirectory.dir("run"))
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(25))
    })
    minHeapSize = "1G"
    maxHeapSize = "2G"
    // The project owner has explicitly agreed to the Minecraft EULA.
    systemProperty("com.mojang.eula.agree", "true")
}

tasks.processResources {
    val properties = mapOf(
        "version" to project.version,
        "kotlinVersion" to kotlin.coreLibrariesVersion,
    )
    inputs.properties(properties)
    filesMatching("plugin.yml") {
        expand(properties)
    }
}
