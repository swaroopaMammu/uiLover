package com.example.uilover.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.uilover.databinding.GridCardItemLayoutBinding
import com.example.uilover.model.CardModel

class HomeGridAdapter(private val context:Context, private val dataList:List<CardModel>):BaseAdapter() {
    override fun getCount(): Int {
      return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: GridCardItemLayoutBinding
        val view: View

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            binding = GridCardItemLayoutBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as GridCardItemLayoutBinding
        }
        binding.data = dataList[position]
        return view
    }

}