package com.android.flickrsearch.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.flickrsearch.R

@Composable
fun ImageItem(photo: UiPhoto) {
    Row {
        AsyncImage(
            model = photo.url,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = photo.name,
            contentScale = ContentScale.Crop
        )

        Text(
            text = photo.name,
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageItemPreview() {
    ImageItem(
        photo = UiPhoto(url = "", name = "Sample Image")
    )
}