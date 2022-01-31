package com.example.graphql.aggregator

import com.example.graphql.Store
import com.example.graphql.repository.StoreRepository
import org.springframework.stereotype.Component

@Component
class StoreAggregator(
    private val storeRepository: StoreRepository,
) {
    suspend fun findStoreById(id: Long) = storeRepository.findById(id)

    suspend fun createStore(store: Store) = storeRepository.save(store)

    suspend fun updateStore(inputStore: Store): Store{
        var store = storeRepository.findById(inputStore.id!!)?: throw Exception("NOT FOUND ${inputStore.id}")
        /**
         * update store
         */
        return store;
    }

    suspend fun deleteStoreById(id: Long){
        storeRepository.deleteById(id)
    }
}