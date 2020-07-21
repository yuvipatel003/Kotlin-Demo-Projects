package com.yuvrajpatel.mvvm_kotlin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuvrajpatel.mvvm_kotlin.R
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces
import de.hdodenhof.circleimageview.CircleImageView

class NicePlacesRecyclerViewAdapter(val placeList : List<NicePlaces>? = null) : RecyclerView.Adapter<NicePlacesRecyclerViewAdapter.ViewHolder>() {

    val TAG = "MVVM-MNicePlacesRepository"

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NicePlacesRecyclerViewAdapter.ViewHolder {
        Log.d(TAG, "onCreateViewHolder()")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.niceplace_recyclerview_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: NicePlacesRecyclerViewAdapter.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder()")
        Log.d("Recycle: " , placeList?.get(position)?.toString())
        placeList?.get(position)?.let { holder.bindItems(it) }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        if (placeList != null) {
            return placeList.size
        }
        return 0
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(place: NicePlaces) {
            Log.d("MVVM-ViewHolder", "bindItems()")
            val textViewName = itemView.findViewById(R.id.recyclerviewNicePlaceName) as TextView
            val imageView = itemView.findViewById(R.id.recyclerviewNicePlaceImage) as CircleImageView
            textViewName.text = place.getPlaceName()
            Glide.with(itemView.context)
                .load(place.getPlaceImage())
                .into(imageView)
        }
    }
}


