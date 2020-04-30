package com.synerzip.assigment.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.synerzip.assigment.models.ResponseModell

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsData(newsList: ResponseModell)

    @Query("SELECT * FROM news_data")
    fun getAllNews(): ResponseModell
}