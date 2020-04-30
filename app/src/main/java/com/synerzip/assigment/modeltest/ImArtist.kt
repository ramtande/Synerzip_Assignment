package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImArtist (

    var label: String? = null,

    var attributes: Attributes__? = null

    ): Parcelable