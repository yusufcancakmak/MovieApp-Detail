package com.yusufcancakmak.detailmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yusufcancakmak.detailmovieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation=binding.bottomNavigation
        val findNavigation=Navigation.findNavController(this@MainActivity,R.id.hostfragment)
        NavigationUI.setupWithNavController(bottomNavigation,findNavigation)
    }
}