package com.pollyannawu.gogolook.data.model

import android.database.Cursor
import com.pollyannawu.gogolook.data.dataclass.Hit
import com.pollyannawu.gogolook.data.dataclass.Result

interface RemoteDataSource {
    fun getDefaultLayoutByRemoteConfig(defaultLayoutCallback: (String) -> Unit)
    suspend fun getImagesFromPixabayAPI(input: String): Result<List<Hit>>

    fun updateSearchHistorySuggestion(query: String): Cursor?
}