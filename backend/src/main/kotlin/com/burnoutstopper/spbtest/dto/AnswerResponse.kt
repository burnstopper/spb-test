package com.burnoutstopper.spbtest.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AnswerResponse(
    @JsonProperty("token")
    val token: String,

    @JsonProperty("result")
    val resultUserDto: ResultUserDto
)