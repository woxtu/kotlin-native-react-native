package io.github.woxtu.overlord.components

import io.github.woxtu.overlord.components.RepositoryListReactNative.FlatList
import io.github.woxtu.overlord.entity.Repository
import io.github.woxtu.overlord.reactnative.FlatListProps
import react.*

@JsModule("react-native")
private external object RepositoryListReactNative {
    val FlatList: RClass<FlatListProps<Repository>>
}

class RepositoryList : RComponent<RepositoryList.Props, RState>() {
    interface Props : RProps {
        var repositories: Array<Repository>
    }

    override fun RBuilder.render() {
        FlatList {
            attrs {
                data = props.repositories
                keyExtractor = { item, _ -> "${item.id}" }
                renderItem = { repositoryListItem(it.item) }
            }
        }
    }
}

fun RBuilder.repositoryList(repositories: Array<Repository>) = child(RepositoryList::class) {
    attrs {
        this.repositories = repositories
    }
}
