package io.github.woxtu.overlord

import io.github.woxtu.overlord.reactnative.NativeModules
import io.github.woxtu.overlord.reactnative.StyleSheet
import io.github.woxtu.overlord.reactnative.Text
import io.github.woxtu.overlord.reactnative.View
import io.github.woxtu.overlord.response.SearchRepositories
import kotlinext.js.jsObject
import kotlinx.serialization.json.JSON
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

external fun alert(message: Any?)

@JsName("App")
class App : RComponent<RProps, RState>() {
    override fun componentDidMount() {
        NativeModules.Api.searchRepositories("kotlin", 0, 5)
                .then {
                    alert(JSON.nonstrict.parse<SearchRepositories>(it).toString())
                }
    }

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
