package com.priyanshu.ultimatedrivers.di

import android.content.Context
import androidx.room.Room
import com.priyanshu.ultimatedrivers.data.local.database.LocalDatabase
import com.priyanshu.ultimatedrivers.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, LocalDatabase::class.java, Constants.LOCAL_DATABASE_NAME)
        .build()

    @Provides
    @Singleton
    fun provideStudentInfoDao(database: LocalDatabase) = database.studentInfoDao()

}