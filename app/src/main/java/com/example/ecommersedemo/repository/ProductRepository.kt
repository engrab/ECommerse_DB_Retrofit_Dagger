package com.example.ecommersedemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecommersedemo.db.FakerDB
import com.example.ecommersedemo.models.Product
import com.example.ecommersedemo.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<Product>>()
    val products :  LiveData<List<Product>>
    get() = _products
    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null){
            fakerDB.fakerDAO().addProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }
}