package io.github.woxtu.overlord

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GitHubClient {
    private val client = HttpClient {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.github.com"
                headers["Accept"] = "application/vnd.github.mercy-preview+json"
            }
        }
    }

    fun searchRepositories(query: String, page: Int, perPage: Int, callback: (String?, Throwable?) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val response = client.get<String> {
                    url {
                        encodedPath = "/search/repositories"
                        parameters["q"] = query
                        parameters["page"] = "${page}"
                        parameters["per_page"] = "${perPage}"
                    }
                }
                callback(response, null)

            } catch (e: Throwable) {
                callback(null, e)
            }
        }
    }
}