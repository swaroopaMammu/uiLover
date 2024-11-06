package com.example.uilover.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uilover.R
import com.example.uilover.model.CardModel
import com.example.uilover.view.binding.HomeBinder

class HomeScreenViewModel : ViewModel() {

    val binder = HomeBinder()

    fun getDataList():List<CardModel>{
        return listOf(
            CardModel(R.drawable.ic_1, "Inbox"),
            CardModel(R.drawable.ic_2, "Map"),
            CardModel(R.drawable.ic_3, "Chat"),
            CardModel(R.drawable.ic_4, "Report"),
            CardModel(R.drawable.ic_5, "Calender"),
            CardModel(R.drawable.ic_6, "Tips"),
            CardModel(R.drawable.ic_7, "Settings"),
            CardModel(R.drawable.ic_8, "Share"),
            CardModel(R.drawable.ic_9, "More"),
        )
    }

    fun setData(){
        binder.username = "Sara\nAnderson"
        binder.image = R.drawable.profile
    }
}