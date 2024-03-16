import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	id("project-report")
	java
	application
	idea
	distribution
}

group = "io.joergi"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
	consistentResolution {
		useCompileClasspathVersions()
	}
}
val javaVersion = JavaVersion.VERSION_21

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(javaVersion.majorVersion))
	}
}
idea {
	project {
		jdkName = javaVersion.majorVersion
		languageLevel = org.gradle.plugins.ide.idea.model.IdeaLanguageLevel(javaVersion)
	}
}
repositories {
	mavenCentral()
	maven {
		url = uri("https://packages.confluent.io/maven")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:3.2.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.3")

	implementation("org.apache.beam:beam-sdks-java-core:2.53.0")
	implementation("org.apache.beam:beam-runners-google-cloud-dataflow-java:2.53.0")
	testImplementation("org.apache.beam:beam-runners-direct-java:2.53.0")


	implementation("org.apache.beam:beam-sdks-java-transform-service-launcher:2.53.0")
	implementation("org.apache.beam:beam-sdks-java-harness:2.53.0")
	implementation("org.apache.beam:beam-vendor-grpc-1_54_0:0.1")
	implementation("org.apache.beam:beam-vendor-guava-32_1_2-jre:0.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks {
	withType<JavaCompile> {
		options.encoding = "UTF-8"
	}
}