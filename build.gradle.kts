import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    val repos by extra { listOf("http://maven.aliyun.com/nexus/content/groups/public","https://jcenter.bintray.com/") }
    repositories {
        repositories { for (u in repos) { maven(u) } }
        google()
    }
}

plugins {
    val springBootVersion = "2.1.1.RELEASE"
    java
    idea
    `java-library`
    id("base")
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("org.springframework.boot") version springBootVersion apply false
    id ("org.jetbrains.kotlin.kapt") version "1.3.10"
    id ("org.jetbrains.kotlin.jvm") version "1.3.10"
    `maven-publish`
}



configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

allprojects{
    repositories {
        mavenCentral()
    }
}

subprojects{
    apply(plugin = "java")
    apply(plugin = "idea")
    apply(plugin = "java-library")
    apply(plugin ="base")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin  = "org.springframework.boot")
    apply(plugin  = "maven-publish")
    tasks{
        "jar"(Jar::class){
            enabled = true
        }
        "bootJar"(BootJar::class){
            enabled = false
        }
    }


    task<Jar>("sourcesJar") {
        classifier = "sources"
        from(sourceSets.main.get().allJava)
    }

    publishing {
        publications {
            create<MavenPublication>("binary") {
                from(components["java"])
            }
            create<MavenPublication>("binaryAndSources") {
                from(components["java"])
                artifact(tasks["sourcesJar"])
            }
        }
        repositories {
            // change URLs to point to your repos, e.g. http://my.org/repo
            maven {
                name = "hhkj"
                url = uri("http://192.168.1.222:8092/repository/maven-snapshots/")
                credentials{
                    username = "admin"
                    password = "am@hao1!2"
                }
            }
//            maven {
//                name = "self"
//                url = uri("$buildDir/repos/internal")
//            }
        }
    }

    tasks.withType<PublishToMavenRepository> {
        onlyIf {
            (repository == publishing.repositories["hhkj"] &&
                    publication == publishing.publications["binary"])
//                    ||
//                    (repository == publishing.repositories["internal"] &&
//                            publication == publishing.publications["binaryAndSources"])
        }
    }

    tasks.withType<PublishToMavenLocal>() {
        onlyIf {
            publication == publishing.publications["binaryAndSources"]
        }
    }

}

project(":data-jpa"){
    dependencies{
        api("org.springframework.boot:spring-boot-starter-data-jpa")
        api("com.querydsl:querydsl-jpa")
        api("org.springframework.boot:spring-boot-starter-test")
        api("org.dbunit:dbunit:2.5.4")
        api("org.apache.ant:ant:1.8.2")
    }
}

project(":data-sample"){
    val querydslVersion = "4.2.1"
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    dependencies{
        compile(project(":data-jpa"))
        compile("com.h2database:h2")
        kapt("com.querydsl:querydsl-apt:${querydslVersion}:jpa")
        compile("org.springframework.boot:spring-boot-starter-web")
    }

}



