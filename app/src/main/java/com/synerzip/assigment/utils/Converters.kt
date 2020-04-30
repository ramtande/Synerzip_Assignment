package com.synerzip.assigment.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.synerzip.assigment.modeltest.Feed



import java.lang.reflect.Type;

class Converters {
    /*@TypeConverter
    fun fromArrayLisr(value: NewsModell?) = Gson().toJson(value)

    @TypeConverter
    fun fromString(value: String) = Gson().fromJson(value, NewsModell::class.java)*//*.toList()*//*

*/
    @TypeConverter
    fun stringToSomeObjectList(data: String?): Feed? {
        val gson = Gson()
        if (data == null) {
            return null
        }
        val listType: Type = object : TypeToken<Feed?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString( /*List<*/
        /*>*/someObjects: Feed?
    ): String? {
        val gson = Gson()
        return gson.toJson(someObjects)
    }
}