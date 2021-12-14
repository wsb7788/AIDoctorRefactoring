package com.project.aidoctor.data.remote.admin

interface AdminListener {
    abstract fun onFailure(message: String)
    abstract fun onSuccess(results: ArrayList<EmUser>)


}