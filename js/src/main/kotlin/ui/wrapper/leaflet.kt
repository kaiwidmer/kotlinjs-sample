package ui.wrapper

import kotlin.js.Json

@JsModule("leaflet")
@JsNonModule
@JsName("L")
external object Leaflet {
    fun map(id: String, config: Json): MapBuilder = definedExternally
    fun tileLayer(url: String, config: Json): TileLayerBuilder = definedExternally
}

external class Map()

external interface MapBuilder {
    fun setView(coordinates: Array<Double>, zoomLevel: Int): Map
}

external interface TileLayerBuilder {
    fun addTo(map: Map)
}