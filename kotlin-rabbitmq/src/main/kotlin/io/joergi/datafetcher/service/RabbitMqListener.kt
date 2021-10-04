package io.joergi.datafetcher.service

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageListener
import org.springframework.stereotype.Service


@Service
class RabbitMqListener : MessageListener {
    override fun onMessage(message: Message) {
        println("Consuming Message - " + String(message.body))
    }
}
