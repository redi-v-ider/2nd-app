package com.example.android.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_child.editText

class ChildActivity : AppCompatActivity() {
    private lateinit var mWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        mWelcome = findViewById(R.id.welcome)
        var name: String = ""
        if (intent.hasExtra(INTENT_EXTRA)) {
            name = intent.getStringExtra(INTENT_EXTRA)!!
            mWelcome.text = "Welcome " + name + "!"
        }

        val mButton: Button = findViewById(R.id.button)
        mButton.setOnClickListener {
            if (name != null) {
                val surname = editText.text.toString()
                if (surname.isBlank() || surname.isEmpty()) {
                    Toast.makeText(this, "enter your surname!", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(this, FinalActivity::class.java)
                    intent.putExtra(Intent.EXTRA_TEXT, name + " " + surname)
                    startActivity(intent)
                }
            }
        }

        val testFragment = TestFragment.newInstance(name)


    }

    companion object {

        const val INTENT_EXTRA = "asda"
        const val INTENT_EXTRA1 = "asda1"
        const val INTENT_EXTRA2 = "asda2"
        const val INTENT_EXTRA3 = "asda3"
        const val INTENT_EXTRA4 = "asda4"


        fun newIntent(context: Context, name: String): Intent {
            val intent = Intent(context, ChildActivity::class.java).apply {
                putExtra(INTENT_EXTRA, name)
            }
            return intent

        }


        fun newInstance(name: String): Fragment {
            val fragment = Fragment()
            val bundle = Bundle()
            bundle.putString(INTENT_EXTRA, name)
            fragment.arguments = bundle

            return fragment
        }
    }

}
