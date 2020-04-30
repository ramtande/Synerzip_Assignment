package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Attributes (
       var amount: String? = null,


    var currency: String? = null

):Parcelable