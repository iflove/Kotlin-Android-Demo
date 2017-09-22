package com.example.lazy.kotlin.douban.domain

import com.google.gson.annotations.SerializedName


/**
 * DouBan
 * Created by lazy on 2017/7/13.
 */
class MovieResourcesProperties(
        count: Int,
        start: Int,
        total: Int,
        val subjects: Array<Subjects>,
        val title: String
) : ResourcesProperties(count, start, total)

class Subjects(
        val rating: Rating,
        val genres: Array<String>,
        val title: String,
        val casts: Array<Cast>,
        @SerializedName("collect_count")
        val collectCount: Int,
        @SerializedName("original_title")
        val originalTitle: String,
        val subtype: String,
        val directors: Array<Cast>,
        val year: String,
        val alt: String,
        val images: Avatars,
        val id: String
)

class Rating(
        val max: Int,
        val average: Float,
        val stars: String,
        val min: Int
)

class Cast(
        val id: Int,
        val name: String,
        val alt: String,
        val avatars: Avatars
)

class Avatars(
        val medium: String,
        val small: String,
        val large: String
)