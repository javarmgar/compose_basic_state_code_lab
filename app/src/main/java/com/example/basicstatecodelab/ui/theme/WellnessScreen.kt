package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/*


UI State:
    what should display on the screen
APP Logic:
    how the app behaves and
    how should react to state changes.

        There are two types of logic:
        - the UI behavior or UI logic,
        - the business logic

        1.- The UI logic:
            - relates to how to display state changes on the screen
                - (for example, the navigation logic or showing snackbars).
        2.- The business logic:
            - is what to do with state changes
                - (for example making a payment or storing user preferences).

ViewModels
    - provide the UI state and access to the business logic located in other layers of the app.
    - survive configuration changes, so they have a longer lifetime than the Composition.
    - They can follow the lifecycle of the host of Compose content—that is, activities, fragments,
        or the destination of a Navigation graph if you're using Compose Navigation.
 */
@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column {
        StatefulCounter(modifier)
        val onCloseTask = { task:WellnessTask -> wellnessViewModel.remove(task) }
        WellnessTaskList(
            listState = wellnessViewModel.tasks,
            onCloseTask = onCloseTask,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun WellnessScreen() {
    BasicStateCodelabTheme {
        WellnessScreen(modifier = Modifier)
    }
}
