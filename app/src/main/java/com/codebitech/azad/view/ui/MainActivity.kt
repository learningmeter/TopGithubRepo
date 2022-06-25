package com.codebitech.azad.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codebitech.azad.R
import com.codebitech.azad.data.remote.api.TopGithubService
import com.codebitech.azad.data.remote.response.GitResponse
import com.codebitech.azad.view.adapter.TopRepoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {

    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var mProgressBar: ProgressBar
    private lateinit var editText: AppCompatEditText
    private lateinit var btn: Button
    private lateinit var languageStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setData()
        setListeners()
        hideProgressBar()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.filter_list)
        mProgressBar = findViewById(R.id.progressbar_main_activity)
        editText = findViewById(R.id.search_edittext)
        btn = findViewById(R.id.btn_search)
    }

    private fun setData() {
        languageStr = "Android"
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setListeners() {
        btn.setOnClickListener {
            languageStr = editText.text.toString()
            apiCall(languageStr)
        }
    }

    private fun apiCall(languageStr: String) {
        showProgressBar()
        val  retrofit = Retrofit.Builder()
            .baseUrl(TopGithubService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val githubService = retrofit.create(TopGithubService::class.java)
        githubService.getRepo(languageStr).enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    recyclerView.adapter =
                        TopRepoAdapter(this@MainActivity,
                            R.layout.rv_single_item, response.body()?.items!!)
                hideProgressBar()
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                call?.cancel()
                hideProgressBar()
            }

        })
    }

    private fun hideProgressBar() {
        mProgressBar.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
        mProgressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
    }
}

