package com.example.valentinabulanova.garderob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.valentinabulanova.garderob.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ThingsAdapter.Listener  {
    lateinit var binding: ActivityMainBinding
    private val adapter = ThingsAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                adapter.addThing(it.data?.getSerializableExtra("thing") as Thing)
            }
        }
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            bAdd.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }

    override fun onClick(thing: Thing) {
        Toast.makeText(this, "Нажали на ${thing.title}", Toast.LENGTH_SHORT).show()
    }
}