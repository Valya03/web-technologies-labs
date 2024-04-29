package ru.restaurant

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


fun getImageFromResources(path: String): String {
    val imagePath = Paths.get(path)
    val data = Files.readAllBytes(imagePath)
    val encoded: ByteArray = Base64.getEncoder().encode(data)
    val imgDataAsBase64 = String(encoded)
    val imgAsBase64 = "data:image/png;base64,$imgDataAsBase64"
    return imgAsBase64
}