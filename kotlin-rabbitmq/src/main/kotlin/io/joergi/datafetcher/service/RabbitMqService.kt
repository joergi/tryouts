package io.joergi.datafetcher.service

import io.joergi.datafetcher.config.RabbitMqConfigProperties
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.MessageListenerContainer
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
class RabbitMqService(@Autowired val rabbitMqConfigProperties: RabbitMqConfigProperties) {

    @Bean
    fun queue(): Queue? {
        return Queue(rabbitMqConfigProperties.queue, false)
    }

    @Bean
    fun connectionFactory(): ConnectionFactory? {
        val cachingConnectionFactory = CachingConnectionFactory(rabbitMqConfigProperties.host)
        cachingConnectionFactory.setUri("amqp://" +
                "${rabbitMqConfigProperties.username}:" +
                "${rabbitMqConfigProperties.password}@" +
                "${rabbitMqConfigProperties.host}:" +
                "${rabbitMqConfigProperties.port}/" +
                "${rabbitMqConfigProperties.virtualhost}"
                )
        return cachingConnectionFactory
    }

    @Bean
    fun messageListenerContainer(connectionFactory: ConnectionFactory?, queue: Queue, rabbitMqListener: RabbitMqListener): MessageListenerContainer? {
        val simpleMessageListenerContainer = SimpleMessageListenerContainer()
        simpleMessageListenerContainer.connectionFactory = connectionFactory!!
        simpleMessageListenerContainer.setQueues(queue)
        simpleMessageListenerContainer.setMessageListener(rabbitMqListener)
        return simpleMessageListenerContainer
    }

}
