package io.joergi.datafetcher

import io.joergi.datafetcher.config.RabbitMqConfigProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(RabbitMqConfigProperties::class)
@SpringBootApplication
class DataFetcherApplication

fun <R : Any> R.logger(): Lazy<Logger> = lazy {
	LoggerFactory.getLogger((if (javaClass.kotlin.isCompanion) javaClass.enclosingClass else javaClass).name)
}

fun main(args: Array<String>) {
	runApplication<DataFetcherApplication>(*args)
}
