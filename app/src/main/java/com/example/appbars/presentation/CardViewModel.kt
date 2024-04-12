package com.example.appbars.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CardViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CardUiState())
    var uiState: StateFlow<CardUiState> = _uiState.asStateFlow()


    fun updateFunc(id: Int) {
        val likeList = _uiState.value.likedCheckList.toMutableList()
        val like = _uiState.value.likedCheckList[id]
        likeList[id] = !like
        addToLikedList(id)
        _uiState.update {
            it.copy(
                likedCheckList = likeList
            )
        }
    }

    private fun addToLikedList(id: Int) {
        //val likeCheckList = _uiState.value.likedCheckList
        val item = _uiState.value.likedCheckList[id]
        val likeList = _uiState.value.likedList.toMutableMap()
        likeList[id] = item
        if (item){
            _uiState.update {
                it.copy(
                    likedList =  likeList
                )
            }

        }
    }
}