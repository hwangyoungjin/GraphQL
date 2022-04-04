package com.example.graphql.error

class StoreNotfoundException(
    override val message: String
):RuntimeException(message)