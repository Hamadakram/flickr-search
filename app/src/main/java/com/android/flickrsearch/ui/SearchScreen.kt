package com.android.flickrsearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen(
    uiState: SearchUiState,
    onSearch: (query: String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            onSearch = onSearch
        )
        when (uiState) {
            is SearchUiState.Content -> ListContent(uiState.content)
            is SearchUiState.Error, SearchUiState.Initial, SearchUiState.Loading -> MessageContent(
                message = stringResource(id = uiState.message)
            )
        }
    }
}

@Composable
private fun ListContent(list: List<UiPhoto>) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list) {
            ImageItem(photo = it)
        }
    }
}

@Composable
private fun MessageContent(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        uiState = SearchUiState.Content(
            content = listOf(
                UiPhoto("", "Sample Image"),
                UiPhoto("", "Sample Image"),
                UiPhoto("", "Sample Image")
            )
        ),
        onSearch = {}
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenInitialPreview() {
    SearchScreen(
        uiState = SearchUiState.Initial,
        onSearch = {}
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenLoadingPreview() {
    SearchScreen(
        uiState = SearchUiState.Loading,
        onSearch = {}
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchScreenErrorPreview() {
    SearchScreen(
        uiState = SearchUiState.Error("Something went wrong"),
        onSearch = {}
    )
}