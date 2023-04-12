package com.example.ecommersedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommersedemo.databinding.ActivityMainBinding
import com.example.ecommersedemo.viewModels.MainViewModel
import com.example.ecommersedemo.viewModels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplication).appComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        binding.rv.layoutManager = GridLayoutManager(this, 2)

        mainViewModel.productLiveData.observe(this) {
            binding.rv.adapter = MainAdapter(it)

        }
    }
}