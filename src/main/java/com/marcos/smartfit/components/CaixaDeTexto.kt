package com.marcos.smartfit.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.marcos.smartfit.ui.theme.BLACK
import com.marcos.smartfit.ui.theme.LIGHT_BLUE
import com.marcos.smartfit.ui.theme.WHITE

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyBoardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = BLACK,
            focusedBorderColor = LIGHT_BLUE,
            focusedLabelColor = LIGHT_BLUE,
            focusedContainerColor = WHITE,
            cursorColor = LIGHT_BLUE
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType)
    )
}