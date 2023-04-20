package com.musicPlayer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class songApiViewModel: ViewModel {
    val liveDataCurrent = MutableLiveData<ApiInfo>()
    val liveDataList = MutableLiveData<List<ApiInfo>>()
}