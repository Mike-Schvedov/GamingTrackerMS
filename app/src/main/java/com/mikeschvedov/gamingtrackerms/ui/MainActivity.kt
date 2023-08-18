package com.mikeschvedov.gamingtrackerms.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikeschvedov.gamingtrackerms.data.AllGameList
import com.mikeschvedov.gamingtrackerms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isSorted = false

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

        // Triggering between sorted list or default view
        binding.floatingActionButton.setOnClickListener {
            isSorted = !isSorted

            val updatedList = if (isSorted) {
                AllGameList.allGameList.sortedBy { it.gameName }
            } else {
                AllGameList.allGameList
            }

            gamesAdapter.updateList(updatedList)
        }

    }
}