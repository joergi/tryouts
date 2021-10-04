package io.joergi.datafetcher.service

import io.joergi.datafetcher.config.RabbitMqConfigProperties
import io.joergi.datafetcher.model.MessageModel
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitMqSenderService(@Autowired val rabbitTemplate: RabbitTemplate, val rabbitMqConfigProperties: RabbitMqConfigProperties) {

    fun send(messageModel: MessageModel) {
        rabbitTemplate.convertAndSend(rabbitMqConfigProperties.exchange,rabbitMqConfigProperties.exchange, messageModel.toString())
    }
}
