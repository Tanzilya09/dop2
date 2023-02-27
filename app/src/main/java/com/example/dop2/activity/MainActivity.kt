package com.example.dop2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dop2.adapters.PagerAdapter
import com.example.dop2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        val adapter = PagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab, position ->
            when(position){
                0 -> {
                    tab.text = "first"
                }
                1 -> {
                    tab.text = "second"
                }
            }
        }.attach()
    }
}