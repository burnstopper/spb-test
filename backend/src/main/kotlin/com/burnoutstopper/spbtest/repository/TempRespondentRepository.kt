package com.burnoutstopper.spbtest.repository

import com.burnoutstopper.spbtest.model.TempRespondent
import org.springframework.data.jpa.repository.JpaRepository

interface TempRespondentRepository : JpaRepository<TempRespondent, Int>{
    fun findByToken(token: String): TempRespondent
}