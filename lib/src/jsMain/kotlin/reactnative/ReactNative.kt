@file:JsModule("react-native")

package io.github.woxtu.overlord.reactnative

import react.RClass
import react.RProps
import react.ReactElement
import kotlin.js.Promise

external interface FlatListProps<T> : RProps {
    interface Info<T> {
        var item: T
        var index: Int
    }

    var data: Array<T>
    var keyExtractor: (T, Int) -> String
    var renderItem: (Info<T>) -> ReactElement
}

external object StyleSheet {
    fun create(obj: dynamic): dynamic
}

external interface ViewProps : RProps {
    var style: dynamic
}

external val View: RClass<ViewProps>

external object NativeModules {
    object Api {
        fun searchRepositories(query: String, page: Int, perPage: Int): Promise<String>
    }
}
