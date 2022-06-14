package com.codingurkan.photoapiapp.view.photodetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingurkan.photoapiapp.model.Hit

class PhotoDetailsViewModel : ViewModel() {

    val currentPhotoDetails = MutableLiveData<Hit>()
}