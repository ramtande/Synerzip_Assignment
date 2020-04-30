package com.synerzip.assigment.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.synerzip.assigment.modeltest.Feed
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "news_data")
data class ResponseModell
    (
    var feed: Feed? = Feed()
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 1
}