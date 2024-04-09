package com.example.appbars.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CardViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CardUiState())
    val uiState: StateFlow<CardUiState> = _uiState.asStateFlow()


    fun updateFun(id: Int) {
        val likeList = _uiState.value.likedList.toMutableList()
        val like = _uiState.value.likedList[id]
        likeList[id] = !like
        _uiState.update {
            it.copy(
                likedList = likeList
            )
        }
    }
}