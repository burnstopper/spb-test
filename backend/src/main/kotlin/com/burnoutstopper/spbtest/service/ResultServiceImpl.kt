package com.burnoutstopper.spbtest.service

import com.burnoutstopper.spbtest.model.Answer
import com.burnoutstopper.spbtest.model.Result
import com.burnoutstopper.spbtest.repository.ResultRepository
import com.burnoutstopper.spbtest.repository.TempRespondentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.*
import kotlin.jvm.optionals.getOrNull

@Service
class ResultServiceImpl @Autowired
constructor(
    private val resultRepository: ResultRepository,
    private val tempRepo: TempRespondentRepository
) : ResultService {

    override fun saveResult(answer: Answer): Result {
        val result = calculateResult(answer)
        resultRepository.save(result)
        return result
    }

    override fun getRecentResults(fromTimestamp: Long): List<Result> {
        val start = OffsetDateTime.ofInstant(Instant.ofEpochSecond(fromTimestamp), ZoneId.of("UTC"))
        val end = start.with(LocalTime.MAX)
        return resultRepository.findAllByDateTimeBetween(start, end)
    }

    override fun getResult(id: Int): Result? {
        return resultRepository.findById(id.toLong()).getOrNull()
    }

    override fun getResults(token: String): List<Result> {
        // val id = Utils.getRespondentId(token) TODO uncomment after integration with respondent microservice
        val id = tempRepo.findByToken(token).id!!
        return resultRepository.findAllByRespondentId(id)
    }

    override fun getByQuizAndRespondent(quizId: Int, respondentId: Int?): List<Result> {
        if (respondentId == null) {
            return resultRepository.findAllByQuizId(quizId)
        }
        return resultRepository.findAllByQuizIdAndRespondentId(respondentId, quizId)
    }

    private fun calculateResult(answer: Answer): Result {
        val catastrophizationSum = catastrophizationSum(answer)
        val selfDutySum = selfDutySum(answer)
        val othersDutySum = othersDutySum(answer)
        val lowFrustrationToleranceSum = lowFrustrationToleranceSum(answer)
        val selfEsteemSum = selfEsteemSum(answer)
        return Result(
            respondentId = answer.respondentId,
            dateTime = answer.dateTime,
            quizId = answer.quizId,
            catastrophization = catastrophizationSum,
            selfDuty = selfDutySum,
            othersDuty = othersDutySum,
            lowFrustrationTolerance = lowFrustrationToleranceSum,
            selfEsteem = selfEsteemSum
        )
    }

    private fun catastrophizationSum(answer: Answer): Int {
        return (7 - answer.answer1.point) + answer.answer6.point + answer.answer11.point + answer.answer16.point +
                answer.answer21.point + (7 - answer.answer26.point) + answer.answer31.point + answer.answer36.point +
                answer.answer41.point + (7 - answer.answer46.point)
    }

    private fun selfDutySum(answer: Answer): Int {
        return answer.answer2.point + answer.answer7.point + answer.answer12.point + (7 - answer.answer17.point) +
                answer.answer22.point + answer.answer27.point + answer.answer32.point + answer.answer37.point +
                (7 - answer.answer42.point) + answer.answer47.point
    }

    private fun othersDutySum(answer: Answer): Int {
        return answer.answer3.point + answer.answer8.point + (7 - answer.answer13.point) + answer.answer18.point +
                answer.answer23.point + (7 - answer.answer28.point) + answer.answer33.point + (7 - answer.answer38.point) +
                answer.answer43.point + answer.answer48.point
    }

    private fun lowFrustrationToleranceSum(answer: Answer): Int {
        return (7 - answer.answer4.point) + answer.answer9.point + answer.answer14.point + answer.answer19.point +
                answer.answer24.point + answer.answer29.point + (7 - answer.answer34.point) + answer.answer39.point +
                answer.answer44.point + (7 - answer.answer49.point)
    }

    private fun selfEsteemSum(answer: Answer): Int {
        return answer.answer5.point + answer.answer10.point + answer.answer15.point + (7 - answer.answer20.point) +
                (7 - answer.answer25.point) + answer.answer30.point + answer.answer35.point + answer.answer40.point +
                answer.answer45.point + answer.answer50.point
    }
}