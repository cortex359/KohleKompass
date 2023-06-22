package de.rwhtaachen.kohlekompass

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.google.android.material.snackbar.Snackbar
import de.rwhtaachen.kohlekompass.ui.theme.KohleKompassTheme

private const val TEXT_SCALE_REDUCTION_INTERVAL = 0.9f

@Composable
fun AutoScalingText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Center,
    textStyle: TextStyle = LocalTextStyle.current,
    targetTextSizeHeight: TextUnit = textStyle.fontSize,
    maxLines: Int = 1,
) {
    var textSize by remember { mutableStateOf(targetTextSizeHeight) }

    Text(
        modifier = modifier,
        text = text,
        color = color,
        textAlign = textAlign,
        fontSize = textSize,
        fontFamily = textStyle.fontFamily,
        fontStyle = textStyle.fontStyle,
        fontWeight = textStyle.fontWeight,
        lineHeight = textStyle.lineHeight,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

            if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
            }
        },
    )
}

class TransactionNotEditableException(message: String) : Exception(message)


/**
 * Darkens the color by 15%
 * Used to change the color of a card when it is selected.
 */
fun cardSelectedColor(color: Color): Color {
    val rgbDelta = 0.85f
    return color.copy(
        color.alpha,
        color.red * rgbDelta,
        color.green * rgbDelta,
        color.blue * rgbDelta
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    searchBarState: MutableState<TextFieldValue>,
    modifier: Modifier = Modifier,
    focusManager: FocusManager,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        cursorColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        containerColor = MaterialTheme.colorScheme.primary,
        focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
        focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary
    )
) {
    TextField(
        value = searchBarState.value,
        onValueChange = { value ->
            searchBarState.value = value
        },
        modifier = modifier,
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
            )
        },
        trailingIcon = {
            if (searchBarState.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        focusManager.clearFocus()
                        searchBarState.value = TextFieldValue("")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = ""
                    )
                }
            }
        },
        singleLine = true,
        shape = shape, // The TextFiled has rounded corners top left and right by default
        colors = colors
    )
}

@Preview
@Composable
fun SearchFieldPreview() {
    KohleKompassTheme {
        val searchBarState = remember { mutableStateOf(TextFieldValue("")) }
        SearchField(searchBarState, modifier = Modifier, LocalFocusManager.current)
    }
}