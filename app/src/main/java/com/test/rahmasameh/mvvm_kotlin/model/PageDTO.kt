package com.test.rahmasameh.mvvm_kotlin.model

data class PageDTO(
    val data: List<UserDTO>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)