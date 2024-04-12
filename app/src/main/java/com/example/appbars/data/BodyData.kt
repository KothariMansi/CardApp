package com.example.appbars.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.appbars.R

data class Body(
    @DrawableRes val drawableRes: Int,
    @StringRes val stringRes: Int,
    val id: Int

)
val data = listOf(
    Body(drawableRes = R.drawable.image1, stringRes = R.string.affirmation1, 0),
    Body(drawableRes = R.drawable.image2, stringRes = R.string.affirmation2, 1),
    Body(drawableRes = R.drawable.image3, stringRes = R.string.affirmation3, 2),
    Body(drawableRes = R.drawable.image4, stringRes = R.string.affirmation4, 3),
    Body(drawableRes = R.drawable.image5, stringRes = R.string.affirmation5, 4),
    Body(drawableRes = R.drawable.image6, stringRes = R.string.affirmation6, 5),
    Body(drawableRes = R.drawable.image7, stringRes = R.string.affirmation7, 6),
    Body(drawableRes = R.drawable.image8, stringRes = R.string.affirmation8, 7),
    Body(drawableRes = R.drawable.image9, stringRes = R.string.affirmation9, 8),
    Body(drawableRes = R.drawable.image10, stringRes = R.string.affirmation10, 9),
)

