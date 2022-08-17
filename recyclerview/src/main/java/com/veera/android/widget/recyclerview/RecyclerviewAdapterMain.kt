package com.veera.android.widget.recyclerview

import android.content.ClipData
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.veera.android.widget.recyclerview.util.recyclerviewData

private const val TAG = "RecyclerviewAdapterMain"
class RecyclerviewAdapterMain(val item:(String) -> Unit) :
    ListAdapter<String, RecyclerviewAdapterMain.RecyclerviewAdapterViewHolder>(Util) {

    class RecyclerviewAdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: String) {
            view.findViewById<TextView>(R.id.title_recyclerview_tv).text  = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapterViewHolder {
        return RecyclerviewAdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapterViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder")
        val data  = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener{
           item(data)
        }
    }

    fun remove(swipedPosition: Int) {
        recyclerviewData.removeAt(swipedPosition)
        notifyDataSetChanged()
    }

    object Util : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: String, newItem: String
        ): Boolean = oldItem == newItem
    }
}


