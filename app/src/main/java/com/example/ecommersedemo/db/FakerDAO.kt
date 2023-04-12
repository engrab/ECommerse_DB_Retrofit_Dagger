package com.example.ecommersedemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecommersedemo.models.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: List<Product>)

    @Query("SELECT * from product")
    suspend fun getProductList():List<Product>
}