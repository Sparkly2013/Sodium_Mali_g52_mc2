plugins {
    id("multiloader-base")
    id("java-library")
    id("net.fabricmc.fabric-loom") version ("1.15.4")
}

base {
    archivesName = "sodium-mali-g52"
}

val configurationPreLaunch = configurations.create("preLaunchDeps") {
    isCanBeResolved = true
}

sourceSets {
    val main = getByName("main")
    val api = create("api")
    val boot = create("boot")

    api.apply {
        java {
            compileClasspath += main.compileClasspath
        }
    }

    boot.apply {
        java {
            compileClasspath += configurationPreLaunch
        }
    }

    main.apply {
        java {
            compileClasspath += api.output
            compileClasspath += boot.output
        }
    }

    create("desktop")
}

repositories {
    mavenLocal()
}

dependencies {
    minecraft(group = "com.mojang", name = "minecraft", version = "1.21.1")
    compileOnly("io.github.llamalad7:mixinextras-common:0.5.0")
    annotationProcessor("io.github.llamalad7:mixinextras-common:0.5.0")
    compileOnly("net.fabricmc:sponge-mixin:0.13.2+mixin.0.8.5")
    compileOnly("net.fabricmc:fabric-loader:0.15.11")
    configurationPreLaunch("org.lwjgl:lwjgl:3.4.1")
    configurationPreLaunch("org.lwjgl:lwjgl-opengl:3.4.1")
    configurationPreLaunch("org.lwjgl:lwjgl-glfw:3.4.1")
    configurationPreLaunch("net.java.dev.jna:jna:5.14.0")
    configurationPreLaunch("net.java.dev.jna:jna-platform:5.14.0")
    configurationPreLaunch("org.slf4j:slf4j-api:2.0.9")
    configurationPreLaunch("org.jspecify:jspecify:1.0.0")
}

loom {
    accessWidenerPath = file("src/main/resources/sodium-common.accesswidener")
    mixin {
        useLegacyMixinAp = false
    }
}

tasks.jar { enabled = false }
