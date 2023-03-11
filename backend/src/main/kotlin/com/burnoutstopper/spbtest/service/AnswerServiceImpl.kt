package com.burnoutstopper.spbtest.service

import com.burnoutstopper.spbtest.model.*
import com.burnoutstopper.spbtest.repository.AnswerRepository
import com.burnoutstopper.spbtest.repository.TempRespondentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerServiceImpl @Autowired
constructor(
    private val answerRepository: AnswerRepository,
    private val resultService: ResultService,
    private val tempRepo: TempRespondentRepository
) : AnswerService {
    override fun saveAnswer(token: String, answer: Answer): Pair<Result, String> {
        var currentToken = token
        val respondent = if (token.isBlank()) {
            currentToken = UUID.randomUUID().toString()
            tempRepo.save(TempRespondent(token = currentToken))
//            Utils.createRespondent() TODO uncomment after integration with respondent microservice
        } else {
//            val id = Utils.getRespondentId(token) TODO uncomment after integration with respondent microservice
            val id = tempRepo.findByToken(currentToken).id
            TempRespondent(id, currentToken)
        }
        answer.respondentId = respondent.id!!
        answerRepository.save(answer)
        return resultService.saveResult(answer) to currentToken
    }

    override fun getAnswer(token: String): Answer {
        val id = tempRepo.findByToken(token).id!!
        //  val id = Utils.getRespondentId(token) TODO uncomment after integration with respondent microservice
        return answerRepository.findByRespondentId(id)
    }
}
