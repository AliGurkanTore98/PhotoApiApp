package com.codingurkan.photoapiapp.view.photodetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.service.ApiClient
import com.codingurkan.photoapiapp.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoDetailsViewModel : ViewModel() {
    val currentPhotoDetails = MutableLiveData<Hit>()
    private val apiClient = ApiClient.getClient().create(ApiService::class.java)
    var job : Job? = null

    fun downloadPhotoDetails(){
        job = viewModelScope.launch(Dispatchers.IO){
            val response = apiClient.getImageDetails()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        currentPhotoDetails.value = it
                    }
                }
            }
        }
    }
}