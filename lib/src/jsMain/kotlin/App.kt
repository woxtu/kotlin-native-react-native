package io.github.woxtu.overlord

import io.github.woxtu.overlord.components.appSearchHeader
import io.github.woxtu.overlord.components.repositoryList
import io.github.woxtu.overlord.entity.Repository
import io.github.woxtu.overlord.nativebase.Container
import io.github.woxtu.overlord.nativebase.Content
import io.github.woxtu.overlord.nativebase.Root
import io.github.woxtu.overlord.reactnative.NativeModules
import io.github.woxtu.overlord.response.SearchRepositories
import kotlinext.js.jsObject
import kotlinx.serialization.json.JSON
import react.*

@JsName("App")
class App : RComponent<RProps, App.State>() {
    interface State : RState {
        var query: String
        var totalCount: Int
        var repositories: Array<Repository>
    }

    override fun App.State.init() {
        query = ""
        totalCount = 0
        repositories = arrayOf()
    }

    override fun RBuilder.render() {
        Root {
            Container {
                appSearchHeader(
                        onSubmit = this@App::onSubmit
                )
                Content {
                    attrs {
                        contentContainerStyle = jsObject<dynamic> {
                            flex = 1
                        }
                    }
                    repositoryList(
                            repositories = state.repositories,
                            onEndReached = this@App::onEndReached
                    )
                }
            }
        }
    }

    private val perPage = 30

    private val currentPage: Int
        get() = state.repositories.size / perPage

    private fun queryUpdated(query: String) =
            setState { this.query = query }

    private fun repositoriesReceived(page: Int, response: SearchRepositories) =
            setState {
                totalCount = response.totalCount
                repositories = if (page < 2) {
                    response.items.toTypedArray()
                } else {
                    repositories + response.items
                }
            }

    private fun searchRepositories(query: String, page: Int, perPage: Int) =
            NativeModules.Api.searchRepositories(query, page, perPage)
                    .then { JSON.nonstrict.parse(SearchRepositories.serializer(), it) }

    private fun onSubmit(query: String) {
        if (query.isNotBlank()) {
            queryUpdated(query)
            searchRepositories(query, 1, perPage)
                    .then { repositoriesReceived(1, it) }
        }
    }

    private fun onEndReached() {
        if (state.repositories.size < state.totalCount) {
            val page = currentPage + 1
            searchRepositories(state.query, page, perPage)
                    .then { repositoriesReceived(page, it) }
        }
    }
}
