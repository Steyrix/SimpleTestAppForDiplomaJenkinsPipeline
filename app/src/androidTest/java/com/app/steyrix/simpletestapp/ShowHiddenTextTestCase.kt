package com.app.steyrix.simpletestapp

import androidx.test.rule.ActivityTestRule
import com.app.steyrix.simpletestapp.screen.MainScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class ShowHiddenTextTestCase : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun showHiddenTextTest() =
        run {

            io.qameta.allure.android.step("1. Убедиться, что приветственное сообщение показано") {
                step("1. Убедиться, что приветственное сообщение показано") {
                    activityTestRule.launchActivity(null)

                    MainScreen {
                        helloTextView {
                            isVisible()
                        }
                    }
                }
            }

            io.qameta.allure.android.step("2. Нажать на кнопку и верифицировать ее состояние и показ текста") {
                step("2. Нажать на кнопку и верифицировать ее состояние и показ текста") {
                    MainScreen {
                        showTextBtn {
                            hasText(R.string.show_text_btn_hint)
                            isVisible()
                            click()
                            hasText(R.string.hide_text_btn_hint)
                        }

                        hiddenTextView {
                            isVisible()
                            hasText(R.string.hidden_text)
                        }
                    }
                }
            }
        }
}