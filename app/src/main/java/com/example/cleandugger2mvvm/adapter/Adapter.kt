package com.example.cleandugger2mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleandugger2mvvm.databinding.CoinItemBinding
import com.example.domain.model.Post

class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

    class MyViewHolder (val binding: CoinItemBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(CoinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTitle.text  = myList[position].chartName

        holder.binding.tvDis.text = myList[position].bpi.usd.rate
        holder.binding.tvValue.text = myList[position].bpi.gbp.rate
        holder.binding.tvCoin.text = myList[position].bpi.eur.rate
       //holder.binding.tvDis.text = myList[position].bpi.wallet.description
       //holder.binding.tvValue.text = myList[position].bpi.wallet.rate
       //holder.binding.tvCoin.text = myList[position].bpi.wallet.symbol
    }

    fun setData(newList: List<Post?> ){
        try {
            myList = newList as List<Post>
            notifyDataSetChanged()
        }catch (e: Exception){

        }

    }





























































}






















