package com.burnoutstopper.spbtest.service

import com.burnoutstopper.spbtest.model.Answer
import com.burnoutstopper.spbtest.model.Result

interface AnswerService {
    fun saveAnswer(token: String, answer: Answer): Pair<Result, String>
    fun getAnswer(token: String): Answer
}