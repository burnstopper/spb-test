package com.burnoutstopper.spbtest.model

enum class AnswerType(val point: Int) {
    COMPLETELY_AGREE(1),
    MOSTLY_AGREE(2),
    SLIGHTLY_AGREE(3),
    SLIGHTLY_DISAGREE(4),
    MOSTLY_DISAGREE(5),
    COMPLETELY_DISAGREE(6)
}