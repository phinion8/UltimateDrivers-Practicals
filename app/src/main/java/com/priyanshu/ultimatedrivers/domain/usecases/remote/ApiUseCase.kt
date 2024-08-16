package com.priyanshu.ultimatedrivers.domain.usecases.remote

import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.domain.models.StudentInfoRequest
import com.priyanshu.ultimatedrivers.domain.repositories.ApiRepository
import com.priyanshu.ultimatedrivers.domain.repositories.LocalRepository
import com.priyanshu.ultimatedrivers.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ApiUseCase @Inject constructor(
    private val apiRepository: ApiRepository,
    private val localRepository: LocalRepository
) {

    fun getInstructorStudentList(
        studentInfoRequest: StudentInfoRequest
    ): Flow<Resource<List<InstructorStudent>>> = flow<Resource<List<InstructorStudent>>> {
        emit(Resource.Loading())
        try {
            val response = apiRepository.getInstructorStudentList(studentInfoRequest)
            if (response.StatusMessage == "Success" && response.Status == "True") {
                localRepository.addInstructorStudentList(response.InstructorStudentList)
                emit(Resource.Success(response.InstructorStudentList))
            } else {
                emit(Resource.Error(response.StatusMessage))
            }

        } catch (e: HttpException) {
            val localResponse = localRepository.getInstructorStudentList()
            emit(Resource.Success(localResponse))
        } catch (e: IOException) {
            val localResponse = localRepository.getInstructorStudentList()
            emit(Resource.Success(localResponse))
        } catch (e: Exception) {
            emit(Resource.Error("Something went wrong..."))
        }
    }.catch {
        emit(Resource.Error("Something went wrong..."))
    }.flowOn(Dispatchers.IO)


}