package com.example.basicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import com.example.basicstatecodelab.ui.theme.WellnessScreen
/*
State in Compose:
DEF: An app's "state" is any value that can change over time.
 -  broad definition
 -  encompasses everything from ->  Room database to -> variable in a class.

 Examples:

 - in a chat app: most recent messages
 - user's profile photo
 - the scroll position in a list of items
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}



