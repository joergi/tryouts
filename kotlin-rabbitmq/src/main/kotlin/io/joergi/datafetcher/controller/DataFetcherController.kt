package io.joergi.datafetcher.controller

import io.joergi.datafetcher.logger
import io.joergi.datafetcher.service.RabbitMqService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data")
class DataFetcherController {

    companion object {
        val log by logger()
    }

    @GetMapping("/")
    fun foo(){
        log.info("hello world")
    }
}
