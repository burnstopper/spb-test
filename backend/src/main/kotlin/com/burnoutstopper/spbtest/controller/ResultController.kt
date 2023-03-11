package com.burnoutstopper.spbtest.controller

import com.burnoutstopper.spbtest.dto.ResultUserDto
import com.burnoutstopper.spbtest.model.Result
import com.burnoutstopper.spbtest.service.ResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/v1/results")
class ResultController @Autowired constructor(private val service: ResultService) {

    @GetMapping
    fun getResultsByToken(@RequestParam("token") token: String): ResponseEntity<List<ResultUserDto>> {
        val results = service.getResults(token).parallelStream().map { convertToDto(it) }.toList()
        return ResponseEntity(results, HttpStatus.OK)
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