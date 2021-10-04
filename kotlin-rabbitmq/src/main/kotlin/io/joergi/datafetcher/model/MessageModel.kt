package io.joergi.datafetcher.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class MessageModel(

    val message: String = ""
)
