package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessTaskList(
    listState: SnapshotStateList<WellnessTask>,
    onCloseTask: (WellnessTask) -> Boolean,
    modifier: Modifier = Modifier,
) {

    /*
    Common patterns in Compose
        implementation of LazyColumn:
        The composable function rememberLazyListState
            -> creates an initial state for the list using rememberSaveable.
            -> When the Activity is recreated, the scroll state is maintained without you having to code anything.

        state parameter with a default value provided by a public rememberX function
            -> is a common pattern in built-in composable functions.


     */
    LazyColumn(modifier = modifier){
        items(
            items = listState,
            key = { task -> task.id }
        ){task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = {onCloseTask(task)}
            )
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun WellnessTaskListPreview(){
//    WellnessTaskList()
//}