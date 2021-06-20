package com.nikodem.todo.services

import com.squareup.moshi.Json

data class RandomCatResponse (
    val breeds: List<Breed>,
    val id: String,
    val url: String,
    val width: Long,
    val height: Long
)

data class Breed (
    val weight: Weight,
    val id: String,
    val name: String,

    @Json(name = "cfa_url")
    val cfaURL: String,

    @Json(name = "vetstreet_url")
    val vetstreetURL: String,

    @Json(name = "vcahospitals_url")
    val vcahospitalsURL: String,

    val temperament: String,
    val origin: String,

    @Json(name = "country_codes")
    val countryCodes: String,

    @Json(name = "country_code")
    val countryCode: String,

    val description: String,

    @Json(name = "life_span")
    val lifeSpan: String,

    val indoor: Long,
    val lap: Long,

    @Json(name = "alt_names")
    val altNames: String,

    val adaptability: Long,

    @Json(name = "affection_level")
    val affectionLevel: Long,

    @Json(name = "child_friendly")
    val childFriendly: Long,

    @Json(name = "dog_friendly")
    val dogFriendly: Long,

    @Json(name = "energy_level")
    val energyLevel: Long,

    val grooming: Long,

    @Json(name = "health_issues")
    val healthIssues: Long,

    val intelligence: Long,

    @Json(name = "shedding_level")
    val sheddingLevel: Long,

    @Json(name = "social_needs")
    val socialNeeds: Long,

    @Json(name = "stranger_friendly")
    val strangerFriendly: Long,

    val vocalisation: Long,
    val experimental: Long,
    val hairless: Long,
    val natural: Long,
    val rare: Long,
    val rex: Long,

    @Json(name = "suppressed_tail")
    val suppressedTail: Long,

    @Json(name = "short_legs")
    val shortLegs: Long,

    @Json(name = "wikipedia_url")
    val wikipediaURL: String,

    val hypoallergenic: Long,

    @Json(name = "reference_image_id")
    val referenceImageID: String
)

data class Weight (
    val imperial: String,
    val metric: String
)
