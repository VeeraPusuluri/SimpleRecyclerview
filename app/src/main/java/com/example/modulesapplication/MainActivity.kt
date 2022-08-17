package com.example.modulesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.modulesapplication.databinding.ActivityMainBinding
import com.veera.android.widget.recyclerview.CustomRecyclerView
import com.veera.android.widget.recyclerview.RecyclerviewAdapterMain
import com.veera.android.widget.recyclerview.util.recyclerviewData

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val bindng get() = _binding!!
    lateinit var customRecyclerView: CustomRecyclerView

    private lateinit var recyclerviewAdapter: RecyclerviewAdapterMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindng.root)

        recyclerviewAdapter = RecyclerviewAdapterMain{

        }
        recyclerviewAdapter.submitList(recyclerviewData)
        customRecyclerView = findViewById(R.id.recyclerview)
        customRecyclerView.adapter = recyclerviewAdapter
    }
}