package com.ktb.ktbnext.screen.account.binding

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class BindingAdapterTest {
    private lateinit var context: Context

    @Before
    fun beforeTests() {
        context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    }

    @Test
    fun `bind Is Visible`() {
        val v = View(context)
        bindIsVisible(v, true)
        Assert.assertTrue(v.isVisible)
    }

    @Test
    fun `bind Text Amount Red`() {
        val v = TextView(context)
        bindTextAmount(v, "-100")
        Assert.assertEquals("red", v.tag)
    }

    @Test
    fun `bind Text Amount Green`() {
        val v = TextView(context)
        bindTextAmount(v, "+100")
        Assert.assertEquals("green", v.tag)
    }

    @Test
    fun `bind Text Amount Gray`() {
        val v = TextView(context)
        bindTextAmount(v, "100")
        Assert.assertEquals("gray", v.tag)
    }
}