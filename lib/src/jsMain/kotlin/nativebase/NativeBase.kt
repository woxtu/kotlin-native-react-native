@file:JsModule("native-base")

package io.github.woxtu.overlord.nativebase

import react.RClass
import react.RProps

external val Container: RClass<RProps>
external val Item: RClass<RProps>
external val Root: RClass<RProps>

external val Left: RClass<RProps>
external val Body: RClass<RProps>
external val Right: RClass<RProps>

external interface ContentProps : RProps {
    var contentContainerStyle: dynamic
}

external val Content: RClass<ContentProps>

external interface ButtonProps : RProps {
    var onPress: (dynamic) -> Unit
    var transparent: Boolean
}

external val Button: RClass<ButtonProps>

external interface HeaderProps : RProps {
    var rounded: Boolean
    var searchBar: Boolean
}

external val Header: RClass<HeaderProps>

external interface IconProps : RProps {
    var name: String
}

external val Icon: RClass<IconProps>

external interface InputProps : RProps {
    var onChangeText: (dynamic) -> Unit
    var onSubmitEditing: (dynamic) -> Unit
    var placeholder: String
}

external val Input: RClass<InputProps>

external interface ListItemProps : RProps {
    var avatar: Boolean
}

external val ListItem: RClass<ListItemProps>

external interface TextProps : RProps {
    var note: Boolean
}

external val Text: RClass<TextProps>

external interface ThumbnailSource {
    var uri: String
}

external interface ThumbnailProps : RProps {
    var small: Boolean
    var source: ThumbnailSource
}

external val Thumbnail: RClass<ThumbnailProps>
