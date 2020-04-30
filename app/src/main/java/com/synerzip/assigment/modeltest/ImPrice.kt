package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImPrice (

    var label: String? = null,


    var attributes: Attributes? = null

    ):Parcelable