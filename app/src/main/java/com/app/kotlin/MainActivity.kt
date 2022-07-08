package com.app.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.app.kotlin.databinding.ActivityMainBinding

const val KEY_INTENT_NAME = "DATA"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNextPage.setOnClickListener {

            if (binding.edittextMain.length() > 0) {

                val text = binding.edittextMain.text.toString()

                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(KEY_INTENT_NAME, text)
                intent.flags =
                    Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK) // here you say the user can't go back to MainActivity from MainActivity2
                startActivity(intent)

            } else {

                Toast.makeText(this, "طفا مقادیر را وارد کنید...", Toast.LENGTH_SHORT).show()

            }

        }

        binding.openWebButton.setOnClickListener {

            val websiteAddress = "https://github.com/fekri86114"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteAddress)) // when you want to pass a link you have to use Uri.parse()
            startActivity(intent)

        }


    }

}