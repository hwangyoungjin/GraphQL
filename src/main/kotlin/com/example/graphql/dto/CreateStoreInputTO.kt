package com.example.graphql.dto

import org.springframework.data.relational.core.mapping.Column

data class CreateStoreInputTO(
    var storeName: String,
    val city: String,
    val state: String,
    val zipCode: String,
)
