package com.priyanshu.ultimatedrivers.domain.repositories

import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.domain.models.StudentInfo
import com.priyanshu.ultimatedrivers.domain.models.StudentInfoRequest

interface ApiRepository {
    suspend fun getInstructorStudentList(
        studentInfoRequest: StudentInfoRequest
    ): StudentInfo
}