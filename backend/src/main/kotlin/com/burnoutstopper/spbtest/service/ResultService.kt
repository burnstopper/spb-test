package com.burnoutstopper.spbtest.service

import com.burnoutstopper.spbtest.model.Answer
import com.burnoutstopper.spbtest.model.Result

interface ResultService {
    fun saveResult(answer: Answer): Result

    fun getRecentResults(fromTimestamp: Long): List<Result>

    fun getResult(id: Int): Result?

    fun getResults(token: String): List<Result>
}