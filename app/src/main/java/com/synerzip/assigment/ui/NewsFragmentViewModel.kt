package com.synerzip.assigment.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.synerzip.assigment.repository.NewsRepository
import com.synerzip.assigment.models.ResponseModell

class NewsFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private var context: Context = application.applicationContext

    var responseModel : LiveData<ResponseModell> = NewsRepository.getNewsFeed(context)

    fun cancelJobs() = NewsRepository.cancelJob()
}