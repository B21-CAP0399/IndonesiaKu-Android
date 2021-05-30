package com.bangkit.idku.app.core.domain.model

import java.util.*

data class IdentityCard(
    // NIK
    val id: String,
    // nama
    val name: String,
    // tempat kelahiran
    val birthPlace: String,
    // tanggal lahir
    val birthDate: Date,
    // Alamat beserta informasi pelengkap
    val address: Address,
    // Agama
    val religion: Religion,
    // True if married & false if not married?
    val marriageStatus: Boolean,
    // Pekerjaan
    val occupation: String,
    // Kewarganegaraan
    val citizenship: String,
    // Berlaku Hingga
    val validUntil: Date,
)

data class Address(
    val address: String,
    val RT: String,
    val RW: String,
    val subDistrict: String,
    val district: String
)

enum class Religion {
    ISLAM,
    BUDDHA,
    KONGHUCU,
    KRISTEN,
    KATOLIK,
    HINDU,
    KEPERCAYAAN_TERHADAP_TUHAN_YME
}