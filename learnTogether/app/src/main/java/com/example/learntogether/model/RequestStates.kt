package com.example.learntogether.model

sealed interface RequestStates {
    data class Success(val result: List<MarsPhoto>) : RequestStates
    data object Loading : RequestStates
    data object Failure: RequestStates
}