package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = getWellnessTasks()
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
        items(list){task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}

private fun getWellnessTasks() = List(30){ i -> WellnessTask(i, "Task # $i")}

@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview(){
    WellnessTaskList()
}