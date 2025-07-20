package org.zr.tickets.util

import org.springframework.security.oauth2.jwt.Jwt
import java.util.UUID

object JwtUtil {
    fun parseUserId(jwt: Jwt): UUID {
        return UUID.fromString(jwt.subject)
    }
}