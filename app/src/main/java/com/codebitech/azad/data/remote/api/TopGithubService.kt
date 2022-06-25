package com.codebitech.azad.data.remote.api

import com.codebitech.azad.data.remote.response.GitResponse
import com.codebitech.azad.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopGithubService {
    companion object{
        const val BASE_URL = Constants.BASE_URL
    }

    @GET("search/repositories")
    fun getRepo(@Query("q") search: String = "Android",
                @Query("sort") sort: String = "stars"
    ): Call<GitResponse>

}