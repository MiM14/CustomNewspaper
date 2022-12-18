package com.example.rss_aggregator_2022.features.data.remote

import org.simpleframework.xml.*

@Root(name = "rss", strict = false)
    data class RssApiModel @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    @field:Path("channel")
    @param:Path("channel")
    var channelTitle: String? = null,

    @field:ElementList(name = "item", inline = true, required = false)
    @param:ElementList(name = "item", inline = true, required = false)
    @field:Path("channel")
    @param:Path("channel")
    var itemList: List<ItemApiModel>? = null
)

@Root(name = "item", strict = false)
data class ItemApiModel @JvmOverloads constructor(
    @field:Element(name = "title")
    @param:Element(name = "title")
    @field:Text(required = false)
    @param:Text(required = false)
    var title: String? = null,

    @field:Element(name = "description")
    @param:Element(name = "description")
    @field:Text(required = false)
    @param:Text(required = false)
    var description: String? = null,

    @field:Element(name = "link")
    @param:Element(name = "link")
    @field:Text(required = false)
    @param:Text(required = false)
    var link: String? = null,

    @field:Element(name = "pubDate")
    @param:Element(name = "pubDate")
    @field:Text(required = false)
    @param:Text(required = false)
    var pubDate: String? = null,

    @field:Element(name = "media:content")
    @param:Element(name = "media:content")
    @field:Text(required = false)
    @param:Text(required = false)
    var content: String? = null,

    @field:Element(name = "dc:creator")
    @param:Element(name = "dc:creator")
    @field:Text(required = false)
    @param:Text(required = false)
    var creator: String? = null
)