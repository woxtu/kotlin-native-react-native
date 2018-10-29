package io.github.woxtu.overlord

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class ApiModule(reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {
    private val client = GitHubClient()

    override fun getName() = "Api"

    @ReactMethod
    fun searchRepositories(query: String, page: Int, perPage: Int, promise: Promise) {
        client.searchRepositories(query, page, perPage) { response, e ->
            if (e != null) {
                promise.reject(e)
            } else {
                promise.resolve(response)
            }
        }
    }
}