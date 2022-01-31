package com.example.graphql.dto

data class UpdateStoreInputTO(
    var storeId: Int,
    var storeName: String,
    val city: String,
    val state: String,
    val zipCode: String,
)