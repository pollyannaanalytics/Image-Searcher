package com.pollyannawu.gogolook.data.model

import android.database.Cursor
import androidx.paging.PagingData
import com.pollyannawu.gogolook.data.dataclass.Hit
import com.pollyannawu.gogolook.data.dataclass.Result
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllImages(): Flow<PagingData<Hit>>
    fun getImageBySearch(query: String = ""): Flow<PagingData<Hit>>

    fun getDefaultLayoutByRemoteConfig(key: String, fallback: String)



    fun updateSearchHistorySuggestion(query: String): Cursor?

    fun saveSearchQuery(query: String)
}