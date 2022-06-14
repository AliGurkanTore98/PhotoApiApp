package com.codingurkan.photoapiapp.view.photolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.codingurkan.photoapiapp.R
import com.codingurkan.photoapiapp.adapter.PhotoListAdapter
import com.codingurkan.photoapiapp.databinding.ActivityPhotoListBinding
import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.view.photodetails.PhotoDetailsActivity

class PhotoListActivity : AppCompatActivity() {

    private var binding : ActivityPhotoListBinding? = null
    private var viewModel : PhotoListViewModel? = null
    private var adapter : PhotoListAdapter? = null
    private var apiKey = "28047783-b1ea0198798957e25a1771204"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initViewModel()
        initObserver()
        viewModel?.downloadPhotos(apiKey)
    }
    private fun initBinding(){
        binding = ActivityPhotoListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(this@PhotoListActivity)[PhotoListViewModel::class.java]
    }

    private fun initObserver(){
        viewModel?.currentPhotoList?.observe(this){
            initAdapter(it)
        }
    }
    private fun initAdapter(photoList : List<Hit>){
        adapter = PhotoListAdapter(photoList , object : PhotoListAdapter.ItemClickListener{
            override fun onClick(data: Hit) {
                navigateToPhotoDetailsActivity(data)
            }

        })
        binding?.rvPhotoList?.adapter = adapter
        binding?.rvPhotoList?.layoutManager = GridLayoutManager(this,3)
    }

    private fun navigateToPhotoDetailsActivity(data: Hit){
        val intent = Intent(this@PhotoListActivity,PhotoDetailsActivity::class.java)
        intent.putExtra("photos",data)
        startActivity(intent)
    }
}