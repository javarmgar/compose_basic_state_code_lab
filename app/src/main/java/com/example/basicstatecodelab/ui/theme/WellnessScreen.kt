package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column {
        StatefulCounter(modifier)
        val listState: SnapshotStateList<WellnessTask> = remember {
            //mutableStateListOf(getWellnessTasks())
            getWellnessTasks().toMutableStateList()
        }
        val onCloseTask = { task:WellnessTask -> listState.remove(task) }
        WellnessTaskList(
            listState = listState,
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
private fun getWellnessTasks() = List(30){ i -> WellnessTask(i, "Task # $i")}