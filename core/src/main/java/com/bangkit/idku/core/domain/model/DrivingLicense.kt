package com.bangkit.idku.core.domain.model

import java.util.*

data class DrivingLicense(
    val licenseNumber: String,
    val name: String,
    val gender: String,
    val bloodType: String,
    val address: String,
    val birthPlace: String,
    val birthDate: Date,
    val bodyHeight: Int,
    val occupation: String,
    val region: String,
    val validUntil: Date
)