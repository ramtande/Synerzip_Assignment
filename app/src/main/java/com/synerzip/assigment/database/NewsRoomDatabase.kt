package com.synerzip.assigment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.synerzip.assigment.dao.NewsDao
import com.synerzip.assigment.models.ResponseModell
import com.synerzip.assigment.utils.Converters

@Database(entities = [ResponseModell::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsRoomDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NewsRoomDatabase? = null

        fun getDatabase(context: Context): NewsRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsRoomDatabase::class.java,
                    "news_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}