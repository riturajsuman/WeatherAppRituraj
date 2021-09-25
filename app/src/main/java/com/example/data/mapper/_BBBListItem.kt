package com.example.data.mapper

import com.example.data.model.DemoModelItem
import com.example.domain.model.DemoListItem

fun List<DemoModelItem>.toGetBBBdataList(): List<DemoListItem> {
    val watchList = this
    val list = mutableListOf<DemoListItem>()

    watchList.forEach {
        val depth = it.depth
        val magnitude = it.magnitude

        list.add(DemoListItem(depth = depth, magnitude = magnitude))
    }
    return list
}