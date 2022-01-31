package com.example.graphql.store.adapter.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.graphql.aggregator.StoreAggregator
import org.springframework.stereotype.Component

@Component
class StoreQueryResolver(
    private val storeAggregator: StoreAggregator
) : GraphQLQueryResolver {
    suspend fun storeById(id: Long) = storeAggregator.findStoreById(id)
}