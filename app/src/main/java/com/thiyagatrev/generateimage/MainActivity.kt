package com.thiyagatrev.generateimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.thiyagatrev.generateimage.ui.theme.GenerateImageTheme

open class MainActivity : ComponentActivity() {

    private var jetCaptureView: MutableState<Data>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenerateImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        jetCaptureView = remember { mutableStateOf(Data(this@MainActivity, name = "thiyaga", designation = "android dev")) }
        Box(modifier = Modifier.fillMaxSize()) {
            AndroidView(modifier = Modifier.wrapContentSize(),
                factory = {
                    Data(it, name = "sandeep", designation = "android devv").apply {
                        post {
                            jetCaptureView?.value = this
                        }
                    }
                }
            )
            Column(modifier = Modifier.align(Alignment.Center).wrapContentHeight().background(color = Color.LightGray)) {

                Button(modifier = Modifier.padding(5.dp), onClick = {
                    jetCaptureView?.value?.capture(jetCaptureView?.value as Data)
                }) {
                    Text(text = "click me")
                }

                Image(
                    modifier = Modifier.padding(5.dp).wrapContentSize(),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null
                )

            }

        }

    }

}

