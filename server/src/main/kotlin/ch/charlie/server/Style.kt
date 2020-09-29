package ch.charlie.server

import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.TagSelector

private val COLOR_PRIMARY = Color("#FFB882")
private val COLOR_SECONDARY = Color("#807267")
private val COLOR_V1 = Color("#FFE4CF")
private val COLOR_V2 = Color("#805C41")
private val all get() = TagSelector("*")

val cssBuilder: CSSBuilder.() -> Unit = {
    all {
        fontFamily = "'Open Sans', sans-serif"
    }
}