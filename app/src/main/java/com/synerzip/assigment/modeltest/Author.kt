package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author (

    var name: Name? = null,


    var uri: Uri? = null

):Parcelable