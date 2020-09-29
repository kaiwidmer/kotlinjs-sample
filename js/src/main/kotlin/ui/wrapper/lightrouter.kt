package ui.wrapper

import kotlin.js.Json

@JsModule("lightrouter")
@JsNonModule
external class LightRouter(config: Config) {
    fun run(): Json? = definedExternally
}

external interface Config {
    var type: String
    var routes: Json
    var handler: Handler
}

fun config(): Config = js("{}")

external interface Handler {
    var welcome: () -> Unit
    var landingPage: () -> Unit
}

fun handler(): Handler = js("{}")