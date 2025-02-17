package hu.delheves.lasius.presentation.dto

import kotlinx.serialization.Serializable

@Serializable
data class FileDTO(
    val id: String? = null,
    val name: String,
    val path: String,
    val size: Long,
    val lastModified: Long,
    val syncStatus: String
)
