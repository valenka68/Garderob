package com.example.valentinabulanova.garderob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valentinabulanova.garderob.databinding.ActivityThingsListBinding

class ThingsList : AppCompatActivity() {
    lateinit var binding: ActivityThingsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThingsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}