package com.priyanshu.ultimatedrivers.data.repositories

import com.priyanshu.ultimatedrivers.data.remote.ApiService
import com.priyanshu.ultimatedrivers.domain.models.StudentInfo
import com.priyanshu.ultimatedrivers.domain.models.StudentInfoRequest
import com.priyanshu.ultimatedrivers.domain.repositories.ApiRepository
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepository {
    override suspend fun getInstructorStudentList(
        studentInfoRequest: StudentInfoRequest
    ): StudentInfo {
        return apiService.getInstructorStudentList(
            hashToken = "",
            studentInfoRequest = studentInfoRequest
        )
    }
}