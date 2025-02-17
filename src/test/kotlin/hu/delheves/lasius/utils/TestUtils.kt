package hu.delheves.lasius.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

object TestUtils {
    private const val SECRET = "your-secret-key"
    private const val ISSUER = "lasius"
    private const val AUDIENCE = "lasius-api"

    fun createTestToken(): String {
        return JWT.create()
            .withAudience(AUDIENCE)
            .withIssuer(ISSUER)
            .withClaim("username", "test-user")
            .sign(Algorithm.HMAC256(SECRET))
    }
}
