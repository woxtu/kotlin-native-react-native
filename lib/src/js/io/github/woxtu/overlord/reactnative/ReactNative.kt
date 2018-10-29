@file:JsModule("react-native")

package io.github.woxtu.overlord.reactnative

import react.RClass
import react.RProps
import kotlin.js.Promise

external object StyleSheet {
    fun create(obj: dynamic): dynamic
}

external interface TextProps : RProps {

}

external val Text: RClass<TextProps>

external interface ViewProps : RProps {
    var style: dynamic
}

external val View: RClass<ViewProps>

external object NativeModules {
    object Api {
        fun searchRepositories(query: String, page: Int, perPage: Int): Promise<String>
    }
}