package com.example.graphql.store.adapter.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.example.graphql.Store
import com.example.graphql.aggregator.StoreAggregator
import com.example.graphql.dto.CreateStoreInputTO
import com.example.graphql.dto.UpdateStoreInputTO
import org.springframework.stereotype.Component

@Component
class StoreMutationResolver(
    private val storeAggregator: StoreAggregator
) : GraphQLMutationResolver {
    suspend fun createStore(input: CreateStoreInputTO) = storeAggregator.createStore(
        Store(
            name = input.storeName,
            status = input.status,
            city = input.city,
            state = input.state,
            zipCode = input.zipCode
        )
    )

    suspend fun updateStore(storeInput: UpdateStoreInputTO): Store {
        return storeAggregator.updateStore(Store(
            id = storeInput.storeId.toLong(),
            name = storeInput.storeName,
            status = storeInput.status,
            city = storeInput.city,
            state = storeInput.state,
            zipCode = storeInput.zipCode,
        ))
    }

    suspend fun deleteStoreById(id: Long): Boolean {
        storeAggregator.deleteStoreById(id)
        return true
    }
}