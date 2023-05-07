package com.android.flickrsearch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.flickrsearch.ui.theme.FlickrSearchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: SearchViewModel = viewModel()
            FlickrSearchTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                SearchScreen(
                    uiState = uiState,
                    onSearch = {
                        if (it.isNotEmpty()) {
                            viewModel.search(it)
                        }
                    }
                )
            }
        }
    }
}