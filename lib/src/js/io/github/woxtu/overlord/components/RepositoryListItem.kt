package io.github.woxtu.overlord.components

import io.github.woxtu.overlord.entity.Repository
import io.github.woxtu.overlord.nativebase.*
import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class RepositoryListItem : RComponent<RepositoryListItem.Props, RState>() {
    interface Props : RProps {
        var repository: Repository
    }

    override fun RBuilder.render() {
        ListItem {
            attrs {
                avatar = true
            }
            Left {
                Thumbnail {
                    attrs {
                        small = true
                        source = jsObject {
                            uri = props.repository.owner.avatarUrl
                        }
                    }
                }
            }
            Body {
                Text {
                    +"${props.repository.owner.name} / ${props.repository.name}"
                }
                Text {
                    attrs {
                        note = true
                    }
                    +(props.repository.description ?: "")
                }
            }
        }
    }
}

fun RBuilder.repositoryListItem(repository: Repository) = child(RepositoryListItem::class) {
    attrs {
        this.repository = repository
    }
}
