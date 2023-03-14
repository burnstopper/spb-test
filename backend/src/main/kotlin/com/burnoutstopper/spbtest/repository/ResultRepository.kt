package com.burnoutstopper.spbtest.repository

import com.burnoutstopper.spbtest.model.Result
import org.springframework.data.jpa.repository.JpaRepository
import java.time.OffsetDateTime

interface ResultRepository: JpaRepository<Result, Long> {
    fun findAllByRespondentId(id: Int): List<Result>
    fun findAllByDateTimeBetween(start: OffsetDateTime, end: OffsetDateTime): List<Result>
    fun findAllByQuizIdAndRespondentId(quizId: Int, respondentId: Int): List<Result>
    fun findAllByQuizId(quizId: Int): List<Result>
}