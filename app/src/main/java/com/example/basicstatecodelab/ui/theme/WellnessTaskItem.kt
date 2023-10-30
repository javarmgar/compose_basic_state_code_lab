package com.example.basicstatecodelab.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WellnessTaskItem( taskName: String, modifier: Modifier = Modifier) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    WellnessTaskItem(
        taskName = taskName,
        checkedState = checkedState,
        onCheck = { newValue -> checkedState = newValue},
        onClose = {},
    )
}


@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    checkedState: Boolean,
    onCheck: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(checked = checkedState, onCheckedChange = onCheck)
        IconButton(
            onClick = onClose
        ) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview(){
    WellnessTaskItem(
        taskName = "task number 1",
    )
}