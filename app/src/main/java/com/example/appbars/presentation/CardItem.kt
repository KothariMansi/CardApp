package com.example.appbars.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BodyItem(
    @DrawableRes img: Int,
    @StringRes desc: Int,
    liked: Boolean,
    likedFun: ()-> Unit,

) {
    //var like by rememberSaveable { mutableStateOf(false) }
    var clicked by rememberSaveable { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .height(220.dp)
        .clickable { clicked = !clicked }
    ) {

        Image(painter = painterResource(id = img), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .weight(3f),
            contentScale = ContentScale.Crop)
        Text(text = stringResource(id = desc),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 6.dp)
        )
        IconButton(modifier = Modifier.weight(1f),
            onClick = {likedFun() }) {
            Icon(imageVector = if (!liked) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                contentDescription = if (liked) "Dislike" else "Like")
        }
    }

    if (clicked) {
        // val alpha by remember { mutableStateOf(true) }
        AlertDialog(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ),

            onDismissRequest = {clicked = false},
            text = {
                Column(
                    modifier = Modifier.animateContentSize(
                        animationSpec = tween(durationMillis = 3000)
                    )
                ) {
                    Image(painter = painterResource(id = img), contentDescription = "",
                        modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = stringResource(id = desc))

                }
            },

            confirmButton = {
                Button(onClick = { clicked = false }) {
                    Text(text = "Close")
                }
            }
        )
    }

}

