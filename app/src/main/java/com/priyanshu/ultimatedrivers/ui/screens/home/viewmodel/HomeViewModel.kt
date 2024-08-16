package com.priyanshu.ultimatedrivers.ui.screens.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyanshu.ultimatedrivers.domain.models.InstructorStudent
import com.priyanshu.ultimatedrivers.domain.models.StudentInfoRequest
import com.priyanshu.ultimatedrivers.domain.usecases.remote.ApiUseCase
import com.priyanshu.ultimatedrivers.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiUseCase: ApiUseCase
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isError: MutableStateFlow<String?> = MutableStateFlow(null)
    val isError = _isError.asStateFlow()

    val instructorStudentList = mutableStateListOf<InstructorStudent>()
    private var page by mutableIntStateOf(1)
    var canPaginate by mutableStateOf(false)
    var listState by mutableStateOf(ListState.IDLE)
    var error by mutableStateOf("")

    init {
        getInstructorStudentListPaginated(
            "",
            "1662",
            "1",
            "",
            "ALL",
            "",
            "",
            "2024"
        )
    }

    fun getInstructorStudentListPaginated(
        evaluationType: String,
        instructorId: String,
        locationId: String,
        searchTitle: String,
        studentPayType: String,
        studentPaymentType: String,
        studentType: String,
        year: String
    ) {
        viewModelScope.launch {
            if (page == 1 || (page != 1 && canPaginate) && listState == ListState.IDLE)
                listState = if (page == 1) ListState.LOADING else ListState.PAGINATING
            apiUseCase.getInstructorStudentList(
                StudentInfoRequest(
                    EvaluationType = evaluationType,
                    InstructorId = instructorId,
                    LocationId = locationId,
                    SPageNo = page.toString(),
                    SearchTitle = searchTitle,
                    StudentPayType = studentPayType,
                    StudentPaymentType = studentPaymentType,
                    StudentType = studentType,
                    Year = year
                )
            ).collect { result ->
                when (result) {
                    is Resource.Success -> {

                        if (result.data != null) {
                            canPaginate = result.data.size == 7

                            if (page == 1) {
                                instructorStudentList.clear()
                                instructorStudentList.addAll(result.data)
                            } else {
                                instructorStudentList.addAll(result.data)
                            }
                            listState = ListState.IDLE
                            if (canPaginate) {
                                page++
                            } else {
                                listState =
                                    if (page == 1) ListState.ERROR else ListState.PAGINATION_END
                            }

                        }

                    }

                    is Resource.Error -> {
                        listState = ListState.ERROR
                        error = result.message.toString()
                    }

                    else -> {}
                }

            }

        }
    }


}

enum class ListState {
    IDLE,
    LOADING,
    PAGINATING,
    ERROR,
    PAGINATION_END
}