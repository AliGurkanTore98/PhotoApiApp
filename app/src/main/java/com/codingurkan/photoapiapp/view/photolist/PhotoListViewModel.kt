package com.codingurkan.photoapiapp.view.photolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.model.PhotoResponseModel
import com.codingurkan.photoapiapp.service.ApiClient
import com.codingurkan.photoapiapp.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoListViewModel : ViewModel() {

    val currentPhotoList = MutableLiveData<List<Hit>>()
    var job : Job? = null
    val apiClient = ApiClient.getClient().create(ApiService::class.java)


    fun downloadPhotos(apiKey : String){
        job = viewModelScope.launch(Dispatchers.IO){
            var response = apiClient.getImageList(apiKey)

            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        currentPhotoList.value = it.hits
                    }
                }
            }
        }
    }
}