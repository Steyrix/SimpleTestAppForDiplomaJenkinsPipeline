package com.app.steyrix.simpletestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showTextButton = findViewById<Button>(R.id.show_txt_btn)
        val showWrongTextButton = findViewById<Button>(R.id.show_wrong_txt_btn)
        val hiddenTextView = findViewById<TextView>(R.id.hidden_text_view)
        val wrongTextView = findViewById<TextView>(R.id.wrong_text_view)

        showTextButton.setOnClickListener {
            val visibility: Int
            val textId: Int

            if (hiddenTextView.visibility == View.VISIBLE) {
                visibility = View.INVISIBLE
                textId = R.string.show_text_btn_hint
            } else {
                visibility = View.VISIBLE
                textId = R.string.hide_text_btn_hint
            }

            hiddenTextView.visibility = visibility
            showTextButton.setText(textId)
        }

        showWrongTextButton.setOnClickListener {
            val visibility = if (wrongTextView.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }

            wrongTextView.visibility = visibility
        }
    }
}
