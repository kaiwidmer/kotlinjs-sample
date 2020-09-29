package ch.charlie.server

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.features.*
import io.ktor.http.content.*
import kotlinx.coroutines.*
import kotlinx.html.dom.createHTMLDocument
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun resources(): ResourceBundle {
    return ResourceBundle.getBundle("strings")
}

@Suppress("unused") // Referenced in application.conf
fun Application.module() {

    val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respond(cause.localizedMessage)
        }
    }

    routing {
        resources("static")
        get("/") {
            call.respondHtml {
                buildIndex()
            }
        }
        get("/welcome") {
            call.respondHtml {
                buildIndex()
            }
        }

        get("/style.css") {
            call.respondCss(cssBuilder)
        }
    }
}

private fun HTML.buildIndex() {
    lang = "de"
    head {
        meta {
            charset = "UTF-8"
        }
        title {
            +"TEST"
        }
        link {
            rel = "stylesheet"
            href = "https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
        }
        link {
            rel = "stylesheet"
            href = "style.css"
        }
        link {
            rel = "stylesheet"
            href = "https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
        }
    }
    body {
        nav {
            id = "main_navigation"
            h1 { +resources().getString("welcome") }
            ul {
                for (n in 1..10) {
                    li { +"$n" }
                }
            }
        }
        div {
            id = "root_map"
        }
        script {
            src = "/js.js"
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
