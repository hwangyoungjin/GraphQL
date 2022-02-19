package com.example.graphql

import com.example.graphql.model.StoreStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table

@Table("STORE")
class Store(
    @Id
    var id: Long? = null,
    var name: String,
    var status: StoreStatus,
    val city: String,
    val state: String,
    @Column(value = "zip_code")
    val zipCode: String,
)
