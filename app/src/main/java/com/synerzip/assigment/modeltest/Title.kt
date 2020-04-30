package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Title (

    var label: String? = null

    ): Parcelable