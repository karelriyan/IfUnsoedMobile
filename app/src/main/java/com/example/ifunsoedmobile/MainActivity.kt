package com.example.ifunsoedmobile

import android.content.Intent // Ditambahkan: Import untuk kelas Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ifunsoedmobile.databinding.ActivityMainBinding // Ditambahkan: Import untuk kelas binding
import com.unsoed.informatikamobile.Halaman2Activity

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initNavigation()
    }

    private fun initNavigation() {
        binding.btnToPage2.setOnClickListener {

            startActivity(Intent(this, Halaman2Activity::class.java))
        }
    }
}