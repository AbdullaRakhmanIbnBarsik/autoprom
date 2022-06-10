package com.bignerdranch.android.autoprom.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Тут будет функционал добавления объявлений"
    }
    val text: LiveData<String> = _text
}