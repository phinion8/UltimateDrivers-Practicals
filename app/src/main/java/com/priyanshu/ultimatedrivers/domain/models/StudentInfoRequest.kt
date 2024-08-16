package com.priyanshu.ultimatedrivers.domain.models

data class StudentInfoRequest(
    val EvaluationType: String,
    val InstructorId: String,
    val LocationId: String,
    val SPageNo: String,
    val SearchTitle: String,
    val StudentPayType: String,
    val StudentPaymentType: String,
    val StudentType: String,
    val Year: String
)