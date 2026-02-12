package com.example.week1kotlinperusteet.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.week1kotlinperusteet.data.model.Task
import androidx.compose.foundation.layout.Column


@Composable
fun DetailDialog(
    task: Task,
    onDismiss: () -> Unit,
    onSave: (Task) -> Unit,
    onDelete: (Task) -> Unit
) {

    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Muokkaa tehtävää") },

        text = {
            Column {

                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )
//raaaaaaaaaah
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(
                    task.copy(
                        title = title,
                        description = description
                    )
                )
            }) {
                Text("Tallenna")
            }
        },
        dismissButton = {
            Button(onClick = { onDelete(task) }) {
                Text("Poista")
            }
        }
    )
}
