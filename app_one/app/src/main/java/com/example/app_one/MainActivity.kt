package com.example.app_one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_one.ui.theme.App_oneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_oneTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()

                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        Greeting(name = "Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name",
        modifier = modifier

            .border(
                width = 4.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Green, Color.Blue),
                    startX = 0.0f,
                    endX = 300.0f
                ),
                shape = CircleShape
            )
            .padding(
                10.dp
            )
            .background(
                color = Color.Cyan,
            )
            .pointerHoverIcon(
       icon = PointerIcon.Hand
            )
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "App_one",
)
@Composable
fun GreetingPreview() {
    App_oneTheme {
        Greeting("Android")
    }
}
