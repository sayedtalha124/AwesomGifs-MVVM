package com.talha.grandgifsearchengine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.talha.grandgifsearchengine.data.Data

class ViewModel : ViewModel() {

    fun getList(filter: ApiInterface): MutableLiveData<PagingData<Data>> {

        val data = PagingDataSource(filter)
        val _pagingDataViewStates = Pager(PagingConfig(pageSize = 10)) {
            data
        }.flow.cachedIn(viewModelScope).asLiveData().let { it as MutableLiveData<PagingData<Data>> }
        return _pagingDataViewStates

    }


    val loadData = MutableLiveData<Data>()
    fun setData(data: Data) {
        loadData.postValue(data)

    }


}


