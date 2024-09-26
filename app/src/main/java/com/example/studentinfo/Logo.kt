package com.example.studentinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Logo : AppCompatActivity() {
    lateinit var img:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        img=findViewById(R.id.arr)
        img.setOnClickListener {
            var i =Intent(this,Csereg::class.java)
            startActivity(i)
        }
    }
}