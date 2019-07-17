package com.example.android.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val fullName = intent.getStringExtra(Intent.EXTRA_TEXT)!!

            final_message.text = "Welcome " + fullName + "!"
            val intent = ChildActivity.newIntent(this, "asdads")

        }
    }

}
