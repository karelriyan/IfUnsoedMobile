package com.unsoed.informatikamobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ifunsoedmobile.R
import com.example.ifunsoedmobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHalaman2Binding
    private val latitude = "-7.429427"
    private val longitude = "109.338082"
    private val gMapsUrl = "http://maps.google.com/maps?q=loc:"
    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding = ActivityHalaman2Binding.inflate(layoutInflater)
    }
}