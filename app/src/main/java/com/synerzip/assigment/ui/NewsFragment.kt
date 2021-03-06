package com.synerzip.assigment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synerzip.assigment.R


import com.synerzip.assigment.models.ResponseModell
import com.synerzip.assigment.modeltest.Entry
import com.synerzip.assigment.ui.adapters.NewsRecyclerViewAdapter
import com.synerzip.assigment.utils.Constants.RESPONSE_DATA_KEY

import kotlinx.android.synthetic.main.fragment_home.*


class NewsFragment : Fragment() {

    private var newsFragmentViewModel: NewsFragmentViewModel? = null
    private val list = ArrayList<Entry>()
    private var responseModel: ResponseModell? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        activity?.application?.let {
            newsFragmentViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(it)
                .create(NewsFragmentViewModel::class.java)
        }

        if (savedInstanceState != null) {
            responseModel = savedInstanceState.getParcelable(RESPONSE_DATA_KEY)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
         initializeSwipeRefreshLayout()
         initializeNewsRecyclerView()
         if (responseModel == null) {
            fetchNewsFeeds()
        } else { populateData(responseModel)
        }
    }

    private fun initializeSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener {
            if (swipeRefreshLayout.isRefreshing) {
                list.clear()
            //    newsRecyclerView.adapter = NewsRecyclerViewAdapter(list)
                fetchNewsFeeds()
            }
        }
    }

    private fun initializeNewsRecyclerView() {
        newsRecyclerView.adapter = NewsRecyclerViewAdapter(list)
        newsRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun enableNewsFeedView(isEnabled: Boolean) {
        newsRecyclerView.visibility = if (isEnabled) View.VISIBLE else View.GONE
        listEmptyTextView.visibility = if (!isEnabled) View.VISIBLE else View.GONE
    }

    private fun fetchNewsFeeds() {
        swipeRefreshLayout.isRefreshing = true
        newsFragmentViewModel?.responseModel?.observe(this, Observer {
            responseModel = it
            swipeRefreshLayout.isRefreshing = false
            populateData(it)
        })
    }


   private fun populateData(it: ResponseModell?) {
        list.clear()
        activity?.title = it?.feed?.title?.label
        if (it?.feed?.entry?.size ?: 0 > 0) {
            list.addAll(it?.feed?.entry!!)
            newsRecyclerView.setLayoutManager(GridLayoutManager(activity?.application?.applicationContext, 1))
            newsRecyclerView.setItemAnimator(DefaultItemAnimator())
            newsRecyclerView.adapter?.notifyDataSetChanged()
            enableNewsFeedView(true)
        } else {
            enableNewsFeedView(false)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(RESPONSE_DATA_KEY, responseModel)
    }


    override fun onDestroy() {
        super.onDestroy()
        newsFragmentViewModel?.cancelJobs()
    }
}