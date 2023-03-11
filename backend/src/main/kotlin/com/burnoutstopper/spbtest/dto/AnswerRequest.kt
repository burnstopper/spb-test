package com.burnoutstopper.spbtest.dto

import com.burnoutstopper.spbtest.model.Answer
import com.fasterxml.jackson.annotation.JsonProperty

data class AnswerRequest(
    @JsonProperty("token")
    val token: String = "",

    @JsonProperty("answer")
    val answer: Answer
)