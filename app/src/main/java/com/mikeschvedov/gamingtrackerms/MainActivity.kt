package com.mikeschvedov.gamingtrackerms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikeschvedov.gamingtrackerms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: AppViewModel by lazy {
        ViewModelProvider(this)[AppViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val gamesAdapter = GTRecyclerViewAdapter(AllGameList.allGameList)
        binding.apply {
            recyclerviewXml.adapter = gamesAdapter
            recyclerviewXml.layoutManager = LinearLayoutManager(applicationContext)
        }


    }
}