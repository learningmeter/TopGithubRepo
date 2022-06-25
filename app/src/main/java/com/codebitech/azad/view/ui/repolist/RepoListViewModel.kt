package com.codebitech.azad.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.codebitech.azad.data.remote.response.Item
import com.codebitech.azad.data.repository.RepoRepository
import com.codebitech.azad.viewmodel.BaseViewModel

class RepoListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}