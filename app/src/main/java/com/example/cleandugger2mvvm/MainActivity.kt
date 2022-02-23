package com.example.cleandugger2mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
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
import com.example.data.model.Coin
import com.example.data.viewModel.CoinViewModel
import com.example.domain.model.Post
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

        coinViewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        coinViewModel.readAllData.observe(this, Observer { coin ->
            adapter.setData(coin)
        })

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
          Log.d("Response", response.body().toString())

            if(response.isSuccessful){

                val  chartName = response.body()?.chartName.toString()
                val  usdRate = response.body()?.bpi!!.usd.rate
                val  gbpRate = response.body()?.bpi!!.gbp.rate
                val  eurRate = response.body()?.bpi!!.eur.rate
                //response.body()?.let { adapter.setData(listOf(it)) }
                val coin = Coin(0, chartName,usdRate,gbpRate,eurRate)
                coinViewModel.addCoin(coin)
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerview() {
        binding?.rcView?.adapter = adapter
        binding?.rcView?.layoutManager = LinearLayoutManager(this)
    }

    private fun inputCheck(chartName: String, usdRate: String, gbpRate: String, eurRate: String): Boolean{
        return !(TextUtils.isEmpty(chartName)
                && TextUtils.isEmpty(usdRate)
                && TextUtils.isEmpty(gbpRate)
                && TextUtils.isEmpty(eurRate))
    }
}