package com.example.nitinkumar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nitinkumar.R
import com.example.nitinkumar.model.Image
import com.squareup.picasso.Picasso

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder>() {

    private var imageList = ArrayList<Image>()
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val feedImage:ImageView = itemView.findViewById(R.id.feedImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val current = imageList[position]
        Picasso.get().load(current.download_url).into(holder.feedImage)
    }

    fun setImage(newImageList: List<Image>){
        imageList.clear()
        imageList.addAll(newImageList)
        notifyDataSetChanged()
    }
}