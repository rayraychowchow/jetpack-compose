package com.example.tryjackpackcompose.ui.inspection

import androidx.lifecycle.MutableLiveData
import com.example.tryjackpackcompose.application_preferences.AccountPreferences
import com.example.tryjackpackcompose.base.BaseViewModel
import com.example.tryjackpackcompose.extension.disposedBy
import com.example.tryjackpackcompose.retrofit.TryJackpackComposeService
import com.example.tryjackpackcompose.retrofit.response.project.ProjectDetailResponse
import io.reactivex.Observable

class InspectionViewModel: BaseViewModel() {

    var ldTextLabel = MutableLiveData("")
    var ldButtonTitle = MutableLiveData("")
    private var projectIds = listOf<String>()

    private var loadedProjectCount = 0
    private var projects: MutableList<ProjectDetailResponse> = mutableListOf()

    override fun onActivityStart() {
        super.onActivityStart()
        ldTextLabel.value = "it.message"
        ldButtonTitle.value = "Get ${AccountPreferences.projectIds.count()} project"
        projectIds = AccountPreferences.projectIds
    }

    fun getFullProjectData() {
        getNextProjectData()?.doOnNext {
            ldTextLabel.value = "All ${projects.count()} GET"
        }?.subscribe({},{})?.disposedBy(disposeBag)
    }

    private fun getNextProjectData(): Observable<MutableList<ProjectDetailResponse>>? {
        if (loadedProjectCount < projectIds.count()) {
            return getFullProjectDataById(projectIds[loadedProjectCount]).switchMap {
                projects.add(it)
                return@switchMap getNextProjectData()
            }
        } else {
            return Observable.fromArray(projects)
        }
    }

    private fun getFullProjectDataById(id: String): Observable<ProjectDetailResponse> {
        return TryJackpackComposeService.PROJECT.getFullProjectData(id).doOnError {
            AccountPreferences.token = null
            ldTextLabel.value = it.message ?: ""
        }.doOnNext {
            loadedProjectCount++
            ldTextLabel.value = "$loadedProjectCount"
        }
    }
}