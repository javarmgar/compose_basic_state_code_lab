package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    listState: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
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
                checkedState = task.checked,
                onClose = {onCloseTask(task)},
                onCheckedTask = { checked:Boolean -> onCheckedTask(task, checked) },
            )
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun WellnessTaskListPreview(){
//    WellnessTaskList()
//}