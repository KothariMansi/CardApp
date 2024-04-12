package com.example.appbars.presentation

import androidx.compose.runtime.Composable
import com.example.appbars.data.Body


@Composable
fun BodyList(
    body: Body,
    like:Boolean,
    likedFunc: () -> Unit
) {

    BodyItem(
        img = body.drawableRes,
        desc = body.stringRes,
        liked = like,
        likedFun = likedFunc
    )
}

@Composable
fun LikedList(
    body: Body,
    like:Boolean,
    likedFunc: () -> Unit
) {
    if (like) {
        BodyItem(
            img = body.drawableRes,
            desc = body.stringRes,
            liked = like,
            likedFun = likedFunc
        )
    }
}
