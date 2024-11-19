package com.marcos.smartfit.hash

import java.security.MessageDigest

fun hashPasswordSHA256(password: String): String {
    // Usar SHA-256 para gerar o hash
    val digest = MessageDigest.getInstance("SHA-256")
    val hashedBytes = digest.digest(password.toByteArray())

    // Converter os bytes para uma string hexadecimal
    return hashedBytes.joinToString("") { "%02x".format(it) }
}