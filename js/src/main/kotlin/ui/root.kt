package ui

import kotlinx.browser.document
import kotlinx.html.dom.append
import kotlinx.html.h1
import kotlinx.html.js.div
import org.w3c.dom.Document
import org.w3c.dom.HTMLElement
import ui.wrapper.*
import kotlin.js.json

fun main() {
    document.body?.append?.div {
        h1 {
            +"Test"
        }
    }

    val handler = handler().apply {
        welcome = {
            document.body?.append?.div {
                h1 {
                    +"WELCOME"
                }
            }
        }
        landingPage = landingPageHandler
    }
    val router = LightRouter(config().apply {
        type = "path"
        this.handler = handler
        routes = json(
                "" to "landingPage",
                "welcome" to "welcome"
        )
    })
    router.run()
}

fun Document.getHtmlElementById(id: String): HTMLElement {
    return getElementById(id) as HTMLElement
}