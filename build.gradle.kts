import kr.entree.spigradle.kotlin.paper
import kr.entree.spigradle.kotlin.papermc

plugins {
    kotlin("jvm") version "1.8.0"
    id("kr.entree.spigradle") version "2.4.3"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.acog"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    papermc()
}

dependencies {
    compileOnly(paper("1.19.3"))
    implementation("io.typecraft:bukkit-object:0.3.0")
    implementation("io.typecraft:bukkit-view-core:5.1.2")
    implementation("io.typecraft:command-bukkit:0.8.0")
    implementation("io.heartpattern.springfox:springfox-starter:0.1.15")
//    compileOnly("me.filoghost.holographicdisplays:holographicdisplays-api:3.0.0") 마지막에 추가

    implementation("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    testCompileOnly("org.projectlombok:lombok:1.18.26")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.26")
}

tasks {
    assemble.get().dependsOn(shadowJar)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

spigot {
    main = "dev.acog.craftfight.CraftFight"
}