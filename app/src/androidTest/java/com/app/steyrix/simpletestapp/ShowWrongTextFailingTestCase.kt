package com.app.steyrix.simpletestapp

import androidx.test.rule.ActivityTestRule
import com.app.steyrix.simpletestapp.screen.MainScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class ShowWrongTextFailingTestCase : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun showWrongTextFailingTestCase() =
        run {
            io.qameta.allure.android.step("1. Verify hello text is visible") {
                step("1. Verify hello text is visible") {
                        activityTestRule.launchActivity(null)

                        MainScreen {
                            helloTextView {
                                isVisible()
                            }
                        }
                    }
                }

            io.qameta.allure.android.step("2. Click button and verify text") {
                step("2. Click button and verify text") {
                    MainScreen {
                        showWrongTxtBtn {
                            hasText(R.string.show_wrong_btn_hint)
                            isVisible()
                            click()
                        }

                        wrongTextView {
                            isVisible()
                            hasText(R.string.hidden_text)
                        }
                    }
                }
            }
        }
}