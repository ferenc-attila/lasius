package hu.delheves.lasius.presentation.dto

import kotlinx.serialization.Serializable

@Serializable
data class SyncConfigDTO(
    val id: String? = null,
    val path: String,
    val syncRule: String,
    val includePattern: String? = null,
    val excludePattern: String? = null,
    val isActive: Boolean = true
)
