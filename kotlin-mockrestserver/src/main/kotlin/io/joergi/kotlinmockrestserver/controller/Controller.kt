package io.joergi.kotlinmockrestserver.controller

import io.joergi.kotlinmockrestserver.client.RestClient
import model.Profile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/profiles" , produces = [MediaType.APPLICATION_JSON_VALUE])
class Controller(@Autowired val restClient: RestClient) {

    @GetMapping("/simple-get")
    fun simpleGetCall(): List<Profile> {
        restClient.callClientGet()
        return listOf(
                    Profile("firstname1", "lastname1"),
                    Profile("firstname2", "lastname2"))

    }

}
