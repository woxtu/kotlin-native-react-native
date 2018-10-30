package io.github.woxtu.overlord.components

import io.github.woxtu.overlord.nativebase.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class AppSearchHeader : RComponent<AppSearchHeader.Props, RState>() {
    interface Props : RProps {

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
                        placeholder = "Search repositories"
                    }
                }
            }
            Button {
                attrs {
                    transparent = true
                }
                Text {
                    +"Search"
                }
            }
        }
    }
}

fun RBuilder.appSearchHeader() = child(AppSearchHeader::class) {

}
