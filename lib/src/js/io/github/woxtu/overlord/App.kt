package io.github.woxtu.overlord

import io.github.woxtu.overlord.components.appSearchHeader
import io.github.woxtu.overlord.components.repositoryList
import io.github.woxtu.overlord.entity.Repository
import io.github.woxtu.overlord.nativebase.Container
import io.github.woxtu.overlord.nativebase.Content
import io.github.woxtu.overlord.reactnative.NativeModules
import io.github.woxtu.overlord.response.SearchRepositories
import kotlinx.serialization.json.JSON
import react.*

@JsName("App")
class App : RComponent<RProps, App.State>() {
    interface State : RState {
        var repositories: Array<Repository>
    }

    override fun App.State.init() {
        repositories = arrayOf()
    }

    override fun componentDidMount() {
        NativeModules.Api.searchRepositories("kotlin", 0, 30)
                .then { JSON.nonstrict.parse(SearchRepositories.serializer(), it) }
                .then { setState { repositories = it.items.toTypedArray() } }
    }

    override fun RBuilder.render() {
        Container {
            appSearchHeader()
            Content {
                repositoryList(state.repositories)
            }
        }
    }
}
