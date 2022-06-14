package com.codingurkan.photoapiapp.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.codingurkan.photoapiapp.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
      //  .placeholder(R.drawable.ic_no_photo)
        .into(this)
}

fun showMessage(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}