package com.example.graphql.dto

import com.example.graphql.model.StoreStatus

data class CreateStoreInputTO(
    var storeName: String,
    val status: StoreStatus,
    val city: String,
    val state: String,
    val zipCode: String,
)
