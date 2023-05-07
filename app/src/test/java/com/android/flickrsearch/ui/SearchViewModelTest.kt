package com.android.flickrsearch.ui

import com.android.flickrsearch.domain.FakePhotoRepository
import com.android.flickrsearch.domain.model.Photo
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModelTest {

    private lateinit var photoRepository: FakePhotoRepository
    private lateinit var viewModel: SearchViewModel
    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        photoRepository = FakePhotoRepository()
        viewModel = SearchViewModel(photoRepository = photoRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Given the view model is initialized, then verify SearchUiState is set to Initial`() {
        assertTrue(viewModel.uiState.value is SearchUiState.Initial)
    }

    @Test
    fun `Given valid content is returned from the repository, when performing a search, then verify SearchUiState is set to Content`() {
        photoRepository.add(Photo("", ""))
        photoRepository.add(Photo("", ""))
        runTest(UnconfinedTestDispatcher()) {
            val states = mutableListOf<SearchUiState>()

            val job = viewModel.uiState
                .onEach(states::add)
                .launchIn(this)

            viewModel.search("any")
            job.cancel()

            assertTrue(states.last() is SearchUiState.Content)
        }
    }

    @Test
    fun `Given a search query, when an exception occurs during search, then verify SearchUiState is set to Error`() {
        // Exception will occur because there are no photos in the repository
        runTest(UnconfinedTestDispatcher()) {
            val states = mutableListOf<SearchUiState>()

            val job = viewModel.uiState
                .onEach(states::add)
                .launchIn(this)

            viewModel.search("any")
            job.cancel()

            assertTrue(states.last() is SearchUiState.Error)
        }
    }
}