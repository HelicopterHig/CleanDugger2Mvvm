package com.example.cleandugger2mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleandugger2mvvm.adapter.Adapter
import com.example.cleandugger2mvvm.databinding.ActivityMainBinding
import com.example.cleandugger2mvvm.presentation.MainViewModel
import com.example.cleandugger2mvvm.presentation.MainViewModelFactory
import com.example.data.dao.CoinDao
import com.example.data.viewModel.CoinViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    @Inject
    lateinit var coinDao: CoinDao

    private lateinit var viewModel: MainViewModel
    private val adapter by lazy { Adapter() }

    private lateinit var coinViewModel: CoinViewModel

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupRecyclerview()

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
          Log.d("Response", response.body().toString())

            if(response.isSuccessful){
                //response.body()?.let { adapter.setData(listOf(it)) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })


        coinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        coinViewModel.readAllData.observe(this, Observer { coin ->
            adapter.setData(coin)
        })

    }

    private fun setupRecyclerview() {

        binding?.rcView?.adapter = adapter
        binding?.rcView?.layoutManager = LinearLayoutManager(this)

    }
}