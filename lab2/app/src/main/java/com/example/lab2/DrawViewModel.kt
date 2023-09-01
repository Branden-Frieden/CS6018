package com.example.lab2

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DrawViewModel : ViewModel() {

    private var _width = 800
    private var _height = 800
    private val _map : MutableLiveData<Bitmap> = MutableLiveData<Bitmap>(Bitmap.createBitmap(_width, _height, Bitmap.Config.ARGB_8888))

    val map = _map as LiveData<Bitmap>

    fun makeBitMap(width: Int, height: Int){
        if(width == _width && height == _height)
            return
        _map.value = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        _width = width
        _height = height

    }
}