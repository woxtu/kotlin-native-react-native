@file:JsModule("react-native")

package io.github.woxtu.overlord.reactnative

import react.RClass
import react.RProps

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
