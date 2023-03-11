package com.burnoutstopper.spbtest.model

import jakarta.persistence.*

//TODO will be removed after integration with respondent microservice
@Entity
@Table(schema = "respondent", name = "respondents")
data class TempRespondent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    val token: String
)