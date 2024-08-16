package com.priyanshu.ultimatedrivers.data.repositories

import com.priyanshu.ultimatedrivers.data.local.dao.StudentInfoDao
import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.domain.repositories.LocalRepository
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val studentInfoDao: StudentInfoDao
): LocalRepository {
    override suspend fun addInstructorStudentList(instructorStudentList: List<InstructorStudent>) {
        studentInfoDao.addInstructorStudentsList(instructorStudentList)
    }

    override fun getInstructorStudentList(): List<InstructorStudent> {
        return studentInfoDao.getInstructorStudentsList()
    }

    override suspend fun clearInstructorList() {
       studentInfoDao.clearInstructorStudentsList()
    }
}