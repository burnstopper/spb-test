package com.burnoutstopper.spbtest.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ResultResearcherDto(

    @JsonProperty("respondent_id")
    val respondentId: Int,

    @JsonProperty("date_time")
    val dateTime: Long,

    @JsonProperty("catastrophization")
    val catastrophization: Int,

    @JsonProperty("duty_to_oneself")
    val dutyToOneself: Int,

    @JsonProperty("due_in_relation_to_others")
    val dueInRelationToOthers: Int,

    @JsonProperty("low_frustration_tolerance")
    val lowFrustrationTolerance: Int,

    @JsonProperty("selfestimation")
    val selfestimation: Int,

    @JsonProperty("quiz_id")
    val quizId: Int?
)
