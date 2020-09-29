package ui

import kotlinx.browser.document
import kotlinx.browser.window
import ui.wrapper.Leaflet
import kotlin.js.json

val landingPageHandler = {
    setupMap()
}

private fun setupMap() {
    val height = window.innerHeight - document.getHtmlElementById("main_navigation").offsetHeight
    document.getHtmlElementById("root_map").style.height = "${height}px"
    val map = Leaflet.map("root_map", json(
            "scrollWheelZoom" to false
    )).setView(arrayOf(47.424060, 9.373669), 14)
    Leaflet.tileLayer("https://tiles.stadiamaps.com/tiles/alidade_smooth/{z}/{x}/{y}{r}.png", json(
            "maxZoom" to 20,
            "attribution" to "&copy; <a href=\"https://stadiamaps.com/\">Stadia Maps</a>, &copy; <a href=\"https://openmaptiles.org/\">OpenMapTiles</a> &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors"
    )).addTo(map)
}