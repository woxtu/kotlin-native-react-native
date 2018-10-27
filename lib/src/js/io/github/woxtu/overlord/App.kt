package io.github.woxtu.overlord

import io.github.woxtu.overlord.reactnative.StyleSheet
import io.github.woxtu.overlord.reactnative.Text
import io.github.woxtu.overlord.reactnative.View
import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

@JsName("App")
class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        View {
            attrs {
                style = styles.container
            }
            Text {
                +"Hello, Kotlin/JS!"
            }
        }
    }
}

private val styles = StyleSheet.create(
        jsObject<dynamic> {
            container = jsObject<dynamic> {
                flex = 1
                justifyContent = "center"
                alignItems = "center"
            }
        }
)
