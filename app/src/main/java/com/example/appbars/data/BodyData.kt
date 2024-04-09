package com.example.appbars.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.appbars.R

data class Body(
    @DrawableRes val drawableRes: Int,
    @StringRes val stringRes: Int
)
val data = listOf(
    Body(drawableRes = R.drawable.image1, stringRes = R.string.affirmation1),
    Body(drawableRes = R.drawable.image2, stringRes = R.string.affirmation2),
    Body(drawableRes = R.drawable.image3, stringRes = R.string.affirmation3),
    Body(drawableRes = R.drawable.image4, stringRes = R.string.affirmation4),
    Body(drawableRes = R.drawable.image5, stringRes = R.string.affirmation5),
    Body(drawableRes = R.drawable.image6, stringRes = R.string.affirmation6),
    Body(drawableRes = R.drawable.image7, stringRes = R.string.affirmation7),
    Body(drawableRes = R.drawable.image8, stringRes = R.string.affirmation8),
    Body(drawableRes = R.drawable.image9, stringRes = R.string.affirmation9),
    Body(drawableRes = R.drawable.image10, stringRes = R.string.affirmation10),




)

