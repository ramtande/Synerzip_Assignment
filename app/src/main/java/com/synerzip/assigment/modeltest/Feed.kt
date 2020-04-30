package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*@Parcelize
data class NewsModel(
    var title: String? = null,
    var description: String? = null,
    var imageHref: String? = null,
) : Parcelable*/
@Parcelize
data class Feed (

    var author: Author? = null,


    var entry: List<Entry>? = null,

      var updated: Updated? = null,

    var rights: Rights_? = null,

       var title: Title_? = null,

    var icon: Icon? = null,

    var link: List<Link_>? = null,

    var id: Id_? = null

): Parcelable