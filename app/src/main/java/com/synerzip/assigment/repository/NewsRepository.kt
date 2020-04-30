package com.synerzip.assigment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.synerzip.assigment.database.NewsRoomDatabase
import com.synerzip.assigment.api.RetrofitBuilder
import com.synerzip.assigment.models.ResponseModell
import com.synerzip.assigment.utils.isNetworkAvailable
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object NewsRepository {

    private var getNewsFeedsJob: CompletableJob? = null

    fun getNewsFeed(context: Context): LiveData<ResponseModell> {
        getNewsFeedsJob = Job()
        return object : LiveData<ResponseModell>() {
            override fun onActive() {
                super.onActive()
                getNewsFeedsJob?.let { job ->
                    CoroutineScope(IO + job).launch {
                        var responseModel: ResponseModell? = null
                        if (isNetworkAvailable(context)) {
                            responseModel = RetrofitBuilder.apiService.getNewsResponse()
                            responseModel.let {
                                NewsRoomDatabase.getDatabase(context).newsDao()
                                    .insertNewsData(it)
                            }
                        } else {
                            responseModel =
                                NewsRoomDatabase.getDatabase(context).newsDao().getAllNews()
                        }


                        withContext(Main) {
                            value = responseModel
                            job.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJob() {
        getNewsFeedsJob?.cancel()
    }
}