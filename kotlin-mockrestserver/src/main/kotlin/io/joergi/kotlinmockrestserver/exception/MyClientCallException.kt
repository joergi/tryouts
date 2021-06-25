package io.joergi.kotlinmockrestserver.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class MyClientCallException(message: String) :
    ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message)
