package com.android.flickrsearch.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.flickrsearch.R
import com.android.flickrsearch.ui.theme.FlickrSearchTheme

val ButtonSpacing = 8.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (query: String) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )

        Spacer(modifier = Modifier.width(ButtonSpacing))

        Button(
            shape = MaterialTheme.shapes.small,
            onClick = {
                onSearch(text.text)
            }
        ) {
            Text(
                text = stringResource(id = R.string.search),
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.width(ButtonSpacing))
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    FlickrSearchTheme {
        SearchBar(onSearch = {})
    }
}