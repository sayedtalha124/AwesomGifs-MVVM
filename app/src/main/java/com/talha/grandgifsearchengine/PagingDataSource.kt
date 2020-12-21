package com.talha.grandgifsearchengine

import androidx.paging.PagingSource
import com.talha.grandgifsearchengine.BuildConfig.API_KEY
import com.talha.grandgifsearchengine.data.Data

class PagingDataSource(private val api: ApiInterface
) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = api.getGifs(API_KEY)
            LoadResult.Page(
                    data = response.data,
                    prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else null,
                    nextKey = if (nextPageNumber < response.pagination.total_count) nextPageNumber + 1 else null
            )


        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
