package io.joergi.datafetcher.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "rabbitmq.amp")
data class RabbitMqConfigProperties(
    val host: String = "",
    val port: Int,
    val username: String = "",
    val password: String = "",
    val virtualhost: String = "",
    val queue: String = "",
    val exchange: String = "",
    val routingkey: String = ""
)
