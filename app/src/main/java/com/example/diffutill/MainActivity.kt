package com.example.diffutill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.diffutill.databinding.ActivityMainBinding
import com.example.diffutill.databinding.FragmentFirstBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val manager: FragmentManager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.frameActivity, FirstFragment())
            .addToBackStack(null)
            .commit()
    }
}