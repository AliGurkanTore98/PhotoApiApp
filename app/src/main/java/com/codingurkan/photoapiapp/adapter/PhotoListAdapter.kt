package com.codingurkan.photoapiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingurkan.photoapiapp.databinding.PhotoListItemsBinding
import com.codingurkan.photoapiapp.model.Hit
import com.codingurkan.photoapiapp.util.loadImage

class PhotoListAdapter(private val photoList : List<Hit>,
                        private val itemClickListener : ItemClickListener) : RecyclerView.Adapter<PhotoListAdapter.PhotoListVH>() {

    class PhotoListVH(val binding: PhotoListItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoListVH {
        val view = PhotoListItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoListVH(view)
    }

    override fun onBindViewHolder(holder: PhotoListVH, position: Int) {
        with(holder.binding){
            ivList.loadImage(photoList[position].largeImageURL)
            userText.text = photoList[position].user

            ivList.setOnClickListener {
                itemClickListener.onClick(photoList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
    interface ItemClickListener{
        fun onClick(data : Hit)
    }
}