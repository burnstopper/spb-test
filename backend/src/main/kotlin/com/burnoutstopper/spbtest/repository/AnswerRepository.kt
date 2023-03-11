package com.burnoutstopper.spbtest.repository

import com.burnoutstopper.spbtest.model.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long> {

    fun findByRespondentId(respondentId: Int): Answer
}

