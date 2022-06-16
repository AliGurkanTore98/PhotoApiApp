package com.codingurkan.photoapiapp.view.photodetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.codingurkan.photoapiapp.databinding.ActivityPhotoDetailsBinding
import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.util.loadImage

class PhotoDetailsActivity : AppCompatActivity() {

    private var binding : ActivityPhotoDetailsBinding? = null
    private var viewModel : PhotoDetailsViewModel? = null
    private val photoDetailsContext= this@PhotoDetailsActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initViewModel()
        getArgs()
        initObserver()
    }
    private fun initBinding(){
        binding = ActivityPhotoDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(photoDetailsContext)[PhotoDetailsViewModel::class.java]
    }
    private fun getArgs(){
        intent?.getSerializableExtra("photos")?.let {
            viewModel?.currentPhotoDetails?.value = it as Hit
        }
    }
    private fun initObserver(){
        viewModel?.currentPhotoDetails?.observe(photoDetailsContext){
            binding?.ivDetails?.loadImage(it.largeImageURL)
            binding?.textUser?.text = it.user
            binding?.textUserId?.text = it.user_id.toString()
            binding?.ivUserDetails?.loadImage(it.userImageURL)
        }
    }
}