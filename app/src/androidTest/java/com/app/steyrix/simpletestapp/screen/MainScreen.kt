package com.app.steyrix.simpletestapp.screen

import com.agoda.kakao.text.KButton
import com.app.steyrix.simpletestapp.MainActivity
import com.app.steyrix.simpletestapp.R
import com.kaspersky.kaspresso.screens.KScreen

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int?
        get() = R.layout.activity_main

    override val viewClass: Class<*>?
        get() = MainActivity::class.java

    val showTextBtn = KButton { withId(R.id.show_txt_btn) }
    val showWrongTxtBtn = KButton { withId(R.id.show_wrong_txt_btn) }
    val hiddenTextView = KButton { withId(R.id.hidden_text_view) }
    val wrongTextView = KButton { withId(R.id.wrong_text_view) }
    val helloTextView = KButton { withId(R.id.text_view) }
}