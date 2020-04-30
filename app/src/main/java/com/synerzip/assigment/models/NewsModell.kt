package com.synerzip.assigment.models

import android.os.Parcelable
import com.synerzip.assigment.modeltest.Feed
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModell(
    var feed: Feed? = null

): Parcelable
