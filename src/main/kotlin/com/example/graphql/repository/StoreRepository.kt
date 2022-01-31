package com.example.graphql.repository

import com.example.graphql.Store
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface StoreRepository: CoroutineCrudRepository<Store, Long>