package com.priyanshu.ultimatedrivers.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.priyanshu.ultimatedrivers.utils.Constants

@Entity(tableName = Constants.INSTRUCTOR_STUDENT_TABLE_NAME)
data class InstructorStudent(
    @PrimaryKey(autoGenerate = true)
    val localId: Int,
    val Addons: String,
    val AdvanceAvailable: String,
    val BalanceAmount: String,
    val CourseCode: String,
    val DocumentDownloadLink: String,
    val DrivingScore: String,
    val DueAmount: String,
    val ExtraLessonType: String,
    val G2Price: String,
    val GPrice: String,
    val Id: String,
    val InstructorShare: String,
    val Is10LessonCompleted: String,
    val IsEvaluationCompleted: String,
    val IsEvaluationeligible: String,
    val IsRoadTestPurchased: String,
    val LessonId: String,
    val PaidP1Amount: String,
    val PaidP2Amount: String,
    val Paidp3Amount: String,
    val PaymentStatus: String,
    val Phone: String,
    val ProgramName: String,
    val RegistrationId: String,
    val RoadTestaddonId: String,
    val Score: String,
    val StudentAddress: String,
    val StudentDue: String,
    val StudentName: String,
    val StudentPaymentStatus: String,
    val StudentPaymentType: String,
    val StudentType: String,
    val TotalExtraLessonCount: String,
    val TotalLessonCount: String,
    val TotalPrice: String,
    val TotalPurchasedExtraLesson: String
)