package com.priyanshu.ultimatedrivers.data.remote

import com.priyanshu.ultimatedrivers.domain.models.StudentInfo
import com.priyanshu.ultimatedrivers.domain.models.StudentInfoRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("api/InstructorStudentList")
    fun getInstructorStudentList(
        @Header("HashToken") hasToken: String,
        @Body studentInfoRequest: StudentInfoRequest
    ): StudentInfo

}