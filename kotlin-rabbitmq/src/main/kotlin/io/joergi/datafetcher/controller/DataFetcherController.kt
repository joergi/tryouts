package io.joergi.datafetcher.controller

import io.joergi.datafetcher.model.MessageModel
import io.joergi.datafetcher.service.RabbitMqSenderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/data")
class DataFetcherController(@Autowired val rabbitMqSenderService: RabbitMqSenderService) {

    @PostMapping("/send")
    fun foo(@RequestBody messageModel: MessageModel){
        rabbitMqSenderService.send(messageModel)
    }
}
