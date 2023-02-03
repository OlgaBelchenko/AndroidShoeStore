package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf(
            Shoe("Jordan", 10.0, "Nike", "The legendary shoe"),
            Shoe("Ultra Running Shoes", 7.5, "Adidas", "Running shoes from Adidas"),
            Shoe("Sneakers", 8.0, "Vans", "Your average sneakers"),
            Shoe("Jordan", 10.0, "Nike", "The legendary shoe"),
            Shoe("Ultra Running Shoes", 7.5, "Adidas", "Running shoes from Adidas")
        )
    }

    fun addShoeToList(name: String, company: String, size: Double, description: String) {
        _shoeList.value!!.add(Shoe(name, size, company, description))
    }
}