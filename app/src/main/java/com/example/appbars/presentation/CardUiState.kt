package com.example.appbars.presentation

data class CardUiState(
    val likedCheckList: List<Boolean> = listOf( false, false, false, false, false, false, false, false, false, false),
    val likedList: Map<Int, Boolean> = mapOf()

)