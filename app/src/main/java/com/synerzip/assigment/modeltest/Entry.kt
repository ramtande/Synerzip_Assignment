package com.synerzip.assigment.modeltest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Entry (

    var imName: ImName? = null,

    var rights: Rights? = null,


    var imPrice: ImPrice? = null,


    var imImage: List<ImImage>? = null,


    var imArtist: ImArtist? = null,


    var title: Title? = null,


    var link: Link? = null,


    var id: Id? = null,


    var imContentType: ImContentType? = null,


    var category: Category? = null,


    var imReleaseDate: ImReleaseDate? = null

    ):Parcelable