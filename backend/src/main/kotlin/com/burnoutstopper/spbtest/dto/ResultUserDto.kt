package com.burnoutstopper.spbtest.dto

import com.burnoutstopper.spbtest.model.Level
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime

/**
 * Result for user
 */
class ResultUserDto( //TODO correct
    @JsonProperty("date_time")
    val dateTime: OffsetDateTime,

    @JsonProperty("catastrophization")
    val catastrophization: Int,

    @JsonProperty("self_duty")
    val selfDuty: Int,

    @JsonProperty("others_duty")
    val othersDuty: Int,

    @JsonProperty("low_frustration_tolerance")
    val lowFrustrationTolerance: Int,

    @JsonProperty("self_esteem")
    val selfEsteem: Int
) {
    val catastrophizationLevel: Level
        @JsonProperty("catastrophization_level")
        get() = getLevel(catastrophization)

    val selfDutyLevel: Level
        @JsonProperty("self_duty_level")
        get() = getLevel(selfDuty)

    val othersDutyLevel: Level
        @JsonProperty("others_duty_level")
        get() = getLevel(othersDuty)

    val lowFrustrationToleranceLevel: Level
        @JsonProperty("low_frustration_tolerance_level")
        get() = getLevel(lowFrustrationTolerance)

    val selfEsteemLevel: Level
        @JsonProperty("self_esteem_level")
        get() = getLevel(selfEsteem)

    private fun getLevel(score: Int): Level {
        if (score > 45)
            return Level.ABSENCE

        if (score >= 30)
            return Level.PRESENCE

        return Level.EXPRESSED
    }
}