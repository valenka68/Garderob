package com.example.valentinabulanova.garderob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.valentinabulanova.garderob.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.plate
    private  var imageList = listOf(
        R.drawable.plate,
        R.drawable.plate2,
        R.drawable.kofta,
        R.drawable.pidj,
        R.drawable.shorti,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }
    private  fun initButtons() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if(indexImage>(imageList.size - 1)) indexImage = 0
            imageId = imageList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val thing = Thing(imageId, edTitle.text.toString(), edDescrip.text.toString())
            val editIntent = Intent().apply {
                putExtra("thing", thing)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }

}