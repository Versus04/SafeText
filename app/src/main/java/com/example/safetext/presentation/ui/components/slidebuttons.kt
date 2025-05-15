package com.example.safetext.presentation.ui.components

import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.sync.Mutex


@Composable
fun Slidebuttons( button1 : String , button2 : String)
{
    var selectedoptions = remember {
        mutableStateListOf(false,false)
    }
    val options = listOf("Login","Sign Up")
    MultiChoiceSegmentedButtonRow{
        options.forEachIndexed { index, option ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                checked = selectedoptions[index],
                onCheckedChange = { selectedoptions[index] = !selectedoptions[index]},
                modifier = TODO(),
                enabled = TODO(),
                colors = TODO(),
                border = TODO(),
                interactionSource = TODO(),
                icon = { SegmentedButtonDefaults.Icon(selectedoptions[index])},
                label = {}
            )
        }
    }

}