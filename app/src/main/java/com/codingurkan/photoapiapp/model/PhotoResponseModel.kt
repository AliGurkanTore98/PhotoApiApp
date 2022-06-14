package com.codingurkan.photoapiapp.model

data class PhotoResponseModel(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)