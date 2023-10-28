package com.example.basicstatecodelab.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

/*
5. Memory in a composable function

The Composition: a description of the UI built by Jetpack Compose when it executes composables.
Initial composition: creation of a Composition by running composables the first time.
Recomposition: re-running composables to update the Composition when data changes.

Compose state tracking system:

Compose has -> special state tracking system
 -> schedules recompositions for composables read a state.
 -> Compose be granular
    -> just recompose those composable functions that need to change, not the whole UI.

    This is done by tracking
        not only "writes" (that is, state changes),
        but also "reads" to the state.
 */

/*
 Event though we are observing an state properly and that the recomposition is taking place every time
 the state changes.
 The code  that is executed reinitialize the variable to zero

 Solution: Use an API that stores the value so that next time retrieve the saved value
    Remember API is the answer

    Using delegate properties with the By operator so that it allows to provide  the getters and setter methods
    of the state to be already implemented
    This let us read and mutate the state without explicitly referring to the value property of the state
 */
@Composable
/*
State driven UI

Compose is a declarative UI framework.
    - Instead of removing UI components or changing their visibility when state changes -> viewBased approach
    - we describe how the UI is under specific conditions of state.
        - As a result of a recomposition being called and UI updated,
        composables might end up entering or leaving the Composition.

                                            <<<<<< Composition >>>>>>><
                                                Recompose 0 or more times
Composable   -> Enters the composition ->           Composable                 -> Leaves the composition

Approach characteristics
    - avoids the complexity of manual view updates
    - less error-prone ( if doing manually we can forget to update one view)

Composable presence in composition
    - Present: called during the initial composition or in recompositions,
    - Not present: not called ( composable nested in an if condition  and this one is not met)


 UI: What the user sees
 UI State: What the app says the user should see

 Composition output: UI tree structure
    Composable 0
        Composable 0.1
        Composable 0.2
        Composable 0.3
            Composable 0.3.1
            Composable 0.3.2
        Composable 0.4
            Composable 0.4.1
 - > inspect the app layout generated by Compose using Android Studio's Layout inspector tool
 */
fun WaterCounter( modifier: Modifier = Modifier) {
    var count: Int by remember { mutableStateOf(0) }
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0){
            /*
            remember stores objects in the Composition, and
            forgets the object if the source location where remember is called
            is not invoked again during a recomposition.
            e.g. here it depends on count , if count == 0 then this never executes leaving the item out
            provoking objet deletion
             */
            var showTask by remember { mutableStateOf(true) }
            if(showTask){
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minutes walk today?",
                    onClose = { showTask = false}
                )
            }
            Text(
                text = "Glasses: $count",
            )
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "Add one")
            }

            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = { count = 0 },
            ) {
                Text(text = "Clear water count")
            }

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