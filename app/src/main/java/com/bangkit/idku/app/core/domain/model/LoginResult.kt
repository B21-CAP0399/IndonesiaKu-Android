package com.bangkit.idku.app.core.domain.model

import com.bangkit.idku.core.domain.model.LoggedInUser

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUser? = null,
    val error: Int? = null
)