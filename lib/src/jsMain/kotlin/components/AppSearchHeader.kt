package io.github.woxtu.overlord.components

import io.github.woxtu.overlord.nativebase.*
import react.*

class AppSearchHeader : RComponent<AppSearchHeader.Props, AppSearchHeader.State>() {
    interface Props : RProps {
        var onSubmit: (String) -> Unit
    }

    interface State : RState {
        var query: String
    }

    override fun RBuilder.render() {
        Header {
            attrs {
                rounded = true
                searchBar = true
            }
            Item {
                Icon {
                    attrs {
                        name = "search"
                    }
                }
                Input {
                    attrs {
                        onChangeText = { setState { query = it } }
                        onSubmitEditing = { props.onSubmit(state.query) }
                        placeholder = "Search repositories"
                    }
                }
            }
            Button {
                attrs {
                    onPress = { props.onSubmit(state.query) }
                    transparent = true
                }
                Text {
                    +"Search"
                }
            }
        }
    }
}

fun RBuilder.appSearchHeader(onSubmit: (String) -> Unit) = child(AppSearchHeader::class) {
    attrs {
        this.onSubmit = onSubmit
    }
}
