package io.joergi.kotlinmockrestserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMockrestserverApplication

fun main(args: Array<String>) {
	runApplication<KotlinMockrestserverApplication>(*args)
}
