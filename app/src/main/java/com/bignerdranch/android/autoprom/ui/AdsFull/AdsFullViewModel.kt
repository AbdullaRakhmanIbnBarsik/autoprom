package com.bignerdranch.android.autoprom.ui.AdsFull

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdsFullViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Тут будет функционал добавления объявлений"
    }
    val text: LiveData<String> = _text
}