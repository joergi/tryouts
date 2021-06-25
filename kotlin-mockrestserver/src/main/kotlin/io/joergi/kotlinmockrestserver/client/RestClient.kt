package io.joergi.kotlinmockrestserver.client

import io.joergi.kotlinmockrestserver.exception.MyClientCallException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RestClient(@Autowired val restTemplate: RestTemplate) {

    fun callClientGet(){

        try {
            restTemplate.getForEntity(
                "/profiles/simple-get",
                Number::class.java
            )
        }catch(exception: Exception){
            throw MyClientCallException("this is an exception")
        }
    }

}
