package com.burnoutstopper.spbtest.model

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(schema = "spb", name = "results")
data class Result(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val respondentId: Int,
    val dateTime: OffsetDateTime,
    val quizId: Int?,
    val catastrophization: Int,
    val selfDuty: Int,
    val othersDuty: Int,
    val lowFrustrationTolerance: Int,
    val selfEsteem: Int
)
