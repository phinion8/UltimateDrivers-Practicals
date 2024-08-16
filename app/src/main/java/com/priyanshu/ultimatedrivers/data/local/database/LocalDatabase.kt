package com.priyanshu.ultimatedrivers.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.priyanshu.ultimatedrivers.data.local.dao.StudentInfoDao
import com.priyanshu.ultimatedrivers.data.local.entities.InstructorStudent

@Database(entities = [InstructorStudent::class], version = 1, exportSchema = false)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun studentInfoDao(): StudentInfoDao
}