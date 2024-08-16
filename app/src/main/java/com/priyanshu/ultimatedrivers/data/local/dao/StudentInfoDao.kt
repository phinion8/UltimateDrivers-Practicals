package com.priyanshu.ultimatedrivers.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent

@Dao
interface StudentInfoDao {

    @Upsert
    fun addInstructorStudentsList(instructorStudent: List<InstructorStudent>)

    @Query("SELECT * FROM instructor_student")
    fun getInstructorStudentsList(): List<InstructorStudent>

    @Query("DELETE FROM instructor_student")
    fun clearInstructorStudentsList()
}