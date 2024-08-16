package com.priyanshu.ultimatedrivers.domain.repositories

import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.domain.models.StudentInfo

interface ApiRepository {
    fun getInstructorStudentList(): List<StudentInfo>
}