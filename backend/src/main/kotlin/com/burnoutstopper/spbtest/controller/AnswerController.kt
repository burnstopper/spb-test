package com.burnoutstopper.spbtest.controller

import com.burnoutstopper.spbtest.dto.AnswerRequest
import com.burnoutstopper.spbtest.dto.AnswerResponse
import com.burnoutstopper.spbtest.dto.ResultUserDto
import com.burnoutstopper.spbtest.model.Result
import com.burnoutstopper.spbtest.service.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/v1/answers")
class AnswerController @Autowired constructor(private val service: AnswerService) {

    @PostMapping
    fun saveAnswer(
        @RequestBody answerRequest: AnswerRequest,
    ): ResponseEntity<AnswerResponse> {
        val (result, currenToken) = service.saveAnswer(answerRequest.token, answerRequest.answer)
        val dto = convertToDto(result)
        val response = AnswerResponse(currenToken, dto)
        return ResponseEntity(response, HttpStatus.OK)
    }

    private fun convertToDto(result: Result): ResultUserDto {
        return ResultUserDto(
            dateTime = result.dateTime,
            catastrophization = result.catastrophization,
            selfDuty = result.selfDuty,
            othersDuty = result.othersDuty,
            lowFrustrationTolerance = result.lowFrustrationTolerance,
            selfEsteem = result.selfEsteem,
        )
    }
}
