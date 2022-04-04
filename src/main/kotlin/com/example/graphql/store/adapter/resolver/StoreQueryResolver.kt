package com.example.graphql.store.adapter.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.graphql.Store
import com.example.graphql.aggregator.StoreAggregator
import com.example.graphql.error.StoreNotfoundException
import org.springframework.stereotype.Component

@Component
class StoreQueryResolver(
    private val storeAggregator: StoreAggregator
) : GraphQLQueryResolver {
    suspend fun storeById(id: Long) : Store? {
        return storeAggregator.findStoreById(id)?: throw StoreNotfoundException("Not found storeId: $id")
    }
}