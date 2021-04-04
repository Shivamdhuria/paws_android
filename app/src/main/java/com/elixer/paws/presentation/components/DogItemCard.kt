package com.elixer.paws.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.elixer.paws.domain.model.Dog
import com.elixer.paws.presentation.theme.PawsTheme
import com.elixer.paws.util.DEFAULT_DOG_IMAGE
import com.elixer.paws.util.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi



@ExperimentalCoroutinesApi
@Composable
fun DogItemCard(dog: Dog, onClick: () -> Unit) {
    PawsTheme {
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(bottom = 6.dp, top = 6.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .clickable(onClick = onClick),
            elevation = 6.dp,

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val image = loadPicture(url = dog.imageUrl, defaultImage = DEFAULT_DOG_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Recipe Featured Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
                Text(
                    text = dog.breed,
                    style = MaterialTheme.typography.h5,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = dog.rating,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}