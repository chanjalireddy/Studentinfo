package com.example.studentinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var rec:RecyclerView

    lateinit var adapter:DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rec=findViewById(R.id.rec)

        val api=intent.getStringExtra("api")
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val repApi=retrofit.create(Api::class.java)
        if(api=="R-22-A") {
            lifecycleScope.launch {
                val repos = repApi.getRepo22a()
                if (repos.data.isNotEmpty()) {
                    val adapter = DataAdapter(this@MainActivity,repos.data)
                    rec.adapter = adapter
                    rec.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
        else if(api=="R-22-B"){
            lifecycleScope.launch {
                val repos = repApi.getRepo22b()
                if (repos.data.isNotEmpty()) {
                    val adapter = DataAdapter(this@MainActivity,repos.data)
                    rec.adapter = adapter
                    rec.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }


        }
        else if(api=="R-22-C"){

            lifecycleScope.launch {
                val repos = repApi.getRepo22c()
                if (repos.data.isNotEmpty()) {
                    val adapter = DataAdapter(this@MainActivity,repos.data)
                    rec.adapter = adapter
                    rec.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }


        }
        else if(api=="R-22-D"){
            lifecycleScope.launch {
                val repos = repApi.getRepo22d()
                if (repos.data.isNotEmpty()) {
                    val adapter = DataAdapter(this@MainActivity,repos.data)
                    rec.adapter = adapter
                    rec.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }


        }
        else if(api=="R-21-A"){}
        else if(api=="R-21-B"){}
        else if(api=="R-21-C"){}
        else if(api=="R-21-D"){}

        }





    }

