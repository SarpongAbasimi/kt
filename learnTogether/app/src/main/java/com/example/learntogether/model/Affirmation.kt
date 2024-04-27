package com.example.learntogether.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

@JvmInline
value class StringResourceId(val value: Int)

@JvmInline
value class ImageResourceId(val value: Int)

data class Affirmation(
   @StringRes val stringResourceId: StringResourceId,
   @DrawableRes val imageResourceId: ImageResourceId
)