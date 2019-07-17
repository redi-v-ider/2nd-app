package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ChildActivity : AppCompatActivity() {
    private lateinit var mWelcome: TextView
    private lateinit var mSurname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        mWelcome = findViewById(R.id.welcome)
        var name:String? = null
        if(intent.hasExtra(Intent.EXTRA_TEXT)){
            name = intent.getStringExtra(Intent.EXTRA_TEXT)!!
            mWelcome.text = "Welcome " + name + "!"
        }
        mSurname = findViewById(R.id.editText)
        val mButton: Button = findViewById(R.id.button)
        mButton.setOnClickListener {
            if (name != null){
                val surname = mSurname.text.toString()
                if (surname.isBlank() || surname.isEmpty()) {
                    Toast.makeText(this, "enter your surname!", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, FinalActivity::class.java)
                    intent.putExtra(Intent.EXTRA_TEXT, name + " " + surname)
                    startActivity(intent)
                }
            }
        }
    }

}
