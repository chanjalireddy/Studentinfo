package com.example.studentinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Csereg : AppCompatActivity() {
    lateinit var but1:Button
    lateinit var but2:Button
    lateinit var but3:Button
    lateinit var but4:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csereg)
        but1=findViewById(R.id.R22)
        but2=findViewById(R.id.R21)
        but3=findViewById(R.id.R19)
        but4=findViewById(R.id.R23)

        but1.setOnClickListener {
            var k= Intent(this,Section::class.java)

            startActivity(k)
        }
        but2.setOnClickListener {
            var j= Intent(this,Section::class.java)

            startActivity(j)


        }
    }
}