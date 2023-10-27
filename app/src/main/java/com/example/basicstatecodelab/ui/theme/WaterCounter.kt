package com.example.basicstatecodelab.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
4. Events in Compose
    - what causes the state to update?
        R:  state is updated in response to events.
    - Events: inputs generated from outside or inside an application:
        outside:The user interacting with the UI -> pressing a button.
        inside: A network response

Key idea: State is. Events happen.


UI update loop

Display state -> Event -> update state -> Display State....

    Event: generated by the user or other part
    Update state: Event handler changes the state
    Display State: The Ui is updated to display the new state
 */
@Composable
fun WaterCounter( modifier: Modifier = Modifier) {
    var count = 0
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Glasses: $count",
        )
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { count++.also { Log.d("WaterCounter", "count: $count") } },
        ) {
            Text(text = "Add one")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    BasicStateCodelabTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WaterCounter()
        }
    }
}