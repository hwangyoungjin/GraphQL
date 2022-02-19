package com.example.graphql.dto

import com.example.graphql.model.StoreStatus

data class UpdateStoreInputTO(
    var storeId: Int,
    var storeName: String,
    val status: StoreStatus,
    val city: String,
    val state: String,
    val zipCode: String,
)