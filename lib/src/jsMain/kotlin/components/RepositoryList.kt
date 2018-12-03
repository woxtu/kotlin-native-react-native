package io.github.woxtu.overlord.components

import io.github.woxtu.overlord.entity.Repository
import io.github.woxtu.overlord.reactnative.FlatList
import io.github.woxtu.overlord.reactnative.FlatListProps
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class RepositoryList : RComponent<RepositoryList.Props, RState>() {
    interface Props : RProps {
        var repositories: Array<Repository>
        var onEndReached: () -> Unit
    }

    override fun RBuilder.render() {
        FlatList<FlatListProps<Repository>> {
            attrs {
                data = props.repositories
                keyExtractor = { item, _ -> "${item.id}" }
                renderItem = { repositoryListItem(it.item) }
                onEndReached = { props.onEndReached() }
                onEndReachedThreshold = 0.0
            }
        }
    }
}

fun RBuilder.repositoryList(repositories: Array<Repository>, onEndReached: () -> Unit) = child(RepositoryList::class) {
    attrs {
        this.repositories = repositories
        this.onEndReached = onEndReached
    }
}
