package com.thiyagatrev.generateimage

import android.content.Context
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.viewinterop.AndroidView

class Data @JvmOverloads constructor(
    context: Context,
    var name: String,
    var designation: String,
) : AbstractComposeView(context) {
    @Composable
    override fun Content() {

        ProfileCard(name, designation)
    }

fun capture(view: Data) {
    val bitmap = ImageUtils.generateShareImage(view)
    ShareUtils.shareImageToOthers(context, "test", bitmap)
}

}