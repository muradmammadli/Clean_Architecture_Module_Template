package com.example.demoproject2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.demoproject2.R
import com.example.demoproject2.adapter.CoinRecyclerAdapter
import com.example.demoproject2.databinding.ActivityMainBinding
import com.example.demoproject2.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coinAdapter: CoinRecyclerAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.state.observe(this) {
            if (!it.isLoading) {
                binding.progressBar.visibility = View.INVISIBLE
                if (it.error.isNotBlank()) {
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.error
                }else {
                    binding.recyclerView.visibility = View.VISIBLE
                    coinAdapter = CoinRecyclerAdapter(it.coins)
                    binding.recyclerView.adapter = coinAdapter
                    Log.d("loading", "isloading")
                }
            }
        }
    }
}
