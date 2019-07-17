package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.et_name
import kotlinx.android.synthetic.main.activity_main.go_button

class MainActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_name.addTextChangedListener(this)

    }

    override fun afterTextChanged(p0: Editable?) {
        if (p0.toString().isNotEmpty()) {
            go_button.isEnabled = true
            go_button.setOnClickListener {
                val name = et_name.text.toString()
                if (name.isBlank()) {
                    Toast.makeText(this, "enter your name!", Toast.LENGTH_SHORT).show()
                } else {

                    val intent = Intent(this, ChildActivity::class.java)
                    startActivity(intent)
                }
            }
        } else {
            go_button.isEnabled = false
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

}
