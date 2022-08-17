package com.veera.android.widget.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.veera.android.widget.recyclerview.databinding.ActivityRecyclerviewBinding


class CustomRecyclerView(context: Context, attributeSet: AttributeSet) :
    RecyclerView(context, attributeSet) {

    private lateinit var binding: ActivityRecyclerviewBinding
    private val TAG = CustomRecyclerView::class.simpleName
    lateinit var recyclerview: RecyclerView

    init {
        binding = ActivityRecyclerviewBinding.inflate(LayoutInflater.from(context))
        recyclerview = binding.recyclerviewAndroid
        attributeSet?.let {
            val attributes =
                context.obtainStyledAttributes(it, R.styleable.CustomRecyclerView).apply {
                    recyclerview.clipToPadding =
                        getBoolean(R.styleable.CustomRecyclerView_android_clipToPadding, false)
                    recycle()
                }
        }
    }

//    private fun setUpItemTouchHelper() {
//        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback =
//            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: ViewHolder,
//                    target: ViewHolder
//                ): Boolean {
//                    return false
//                }
//
//                override fun onSwiped(viewHolder: ViewHolder, swipeDir: Int) {
//                    val swipedPosition = viewHolder.adapterPosition
//                    val adapter: RecyclerviewAdapterMain =
//                        recyclerview.getAdapter() as RecyclerviewAdapterMain
//                    adapter.remove(swipedPosition)
//                }
//            }
//        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
//        itemTouchHelper.attachToRecyclerView(recyclerview)
//    }

    fun setAdapter(adapter: RecyclerviewAdapterMain) {
        recyclerview.adapter = adapter
    }


    override fun onFinishInflate() {
        super.onFinishInflate()
        binding = ActivityRecyclerviewBinding.bind(this)
    }


}