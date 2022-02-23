package com.example.cleandugger2mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleandugger2mvvm.databinding.CoinItemBinding
import com.example.data.model.Coin
import com.example.domain.model.Post

class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>(){

    private var myList = emptyList<Coin>()

    class MyViewHolder (val binding: CoinItemBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       // holder.binding.tvTitle.text  = myList[position].chartName
       // holder.binding.tvDis.text = myList[position].bpi.usd.rate
       // holder.binding.tvValue.text = myList[position].bpi.gbp.rate
       // holder.binding.tvCoin.text = myList[position].bpi.eur.rate
        val currentItem = myList[position]
        holder.binding.tvTitle.text = currentItem.chartName.toString()
        holder.binding.tvDis.text = currentItem.usdRate.toString()
        holder.binding.tvValue.text = currentItem.gbpRate.toString()
        holder.binding.tvCoin.text = currentItem.eurRate.toString()
    }

    fun setData(coin: List<Coin> ){
      // try {
      //     myList = newList as List<Post>
      //     notifyDataSetChanged()
      // }catch (e: Exception){

      // }
        this.myList = coin
        notifyDataSetChanged()


    }





























































}






















