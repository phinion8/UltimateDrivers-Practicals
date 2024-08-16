package com.priyanshu.ultimatedrivers.domain.repositories

import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent


interface LocalRepository {
    suspend fun addInstructorStudentList(instructorStudentList: List<InstructorStudent>)
    fun getInstructorStudentList(): List<InstructorStudent>
    suspend fun clearInstructorList()
}