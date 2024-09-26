package com.example.studentinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Section : AppCompatActivity() {
    lateinit var AS:Button
    lateinit var BS:Button
    lateinit var CS:Button
    lateinit var DS:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)
        AS=findViewById(R.id.A)
        BS=findViewById(R.id.B)
        CS=findViewById(R.id.C)
        DS=findViewById(R.id.D)

        AS.setOnClickListener {
            var t =Intent(this,MainActivity::class.java)
            t.putExtra("api","R-22-A")
            startActivity(t)
        }
        BS.setOnClickListener {
            var bs =Intent(this,MainActivity::class.java)
            bs.putExtra("api","R-22-B")
            startActivity(bs)
        }
        CS.setOnClickListener {
            var cs =Intent(this,MainActivity::class.java)
            cs.putExtra("api","R-22-C")
            startActivity(cs)
        }



        DS.setOnClickListener {
            var p =Intent(this,MainActivity::class.java)
            p.putExtra("api","R-22-D")
            startActivity(p)
        }

    }
}