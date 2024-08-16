package com.priyanshu.ultimatedrivers.domain.models

data class StudentInfo(
    val InstructorStudentList: List<InstructorStudent>,
    val Status: String,
    val StatusMessage: String
)