package com.example.viewmodelintentdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodelintentdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe the counter from ViewModel
        viewModel.counter.observe(this) { count ->
            binding.textViewCounter.text = count.toString()
        }

        // Button to increment the counter
        binding.buttonIncrement.setOnClickListener {
            viewModel.incrementCounter()
        }

        // Button to open SecondActivity
        binding.buttonNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Button to open a webpage using implicit intent
        binding.buttonOpenWebpage.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW).apply {
                data = android.net.Uri.parse("https://www.example.com")
            }
            startActivity(webIntent)
        }
    }
}
