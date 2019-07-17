package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mName: EditText
    private lateinit var mButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mName = findViewById(R.id.et_name)
        mButton = findViewById(R.id.go_button)
        mButton.setOnClickListener {
            val name = mName.text.toString()
            if(name.isEmpty() || name.isBlank()){
                Toast.makeText(this, "enter your name!", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, ChildActivity::class.java)
                intent.putExtra(Intent.EXTRA_TEXT, name)
                startActivity(intent)
            }
        }
    }
}
