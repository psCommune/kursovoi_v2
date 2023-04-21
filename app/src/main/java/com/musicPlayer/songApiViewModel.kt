package com.musicPlayer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class songApiViewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<ApiSongModel>()
    val liveDataList = MutableLiveData<List<ApiSongModel>>()
}