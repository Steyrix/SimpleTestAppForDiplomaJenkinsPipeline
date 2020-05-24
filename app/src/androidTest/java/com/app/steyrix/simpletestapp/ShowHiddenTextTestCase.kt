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
            step("1. Verify hello text is visible") {
                activityTestRule.launchActivity(null)

                MainScreen {
                    helloTextView {
                        isVisible()
                    }
                }
            }

            step("2. Click button and verify text and button text change") {
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