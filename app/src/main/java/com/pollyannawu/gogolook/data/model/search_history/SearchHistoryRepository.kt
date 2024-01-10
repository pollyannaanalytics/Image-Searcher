package com.pollyannawu.gogolook.data.model.search_history

import com.google.firestore.v1.Cursor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchHistoryRepository @Inject constructor(private val searchHistoryDataSource: SearchHistoryDataSource){
    fun saveSearchQuery(query: String){
        searchHistoryDataSource.saveSearchQuery(query)

    }
    fun updateSearchHistorySuggestion(query: String){
        searchHistoryDataSource.updateSearchHistorySuggestion(query)
    }
}