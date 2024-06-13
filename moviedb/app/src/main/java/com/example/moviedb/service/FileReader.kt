package com.example.moviedb.service

import java.io.File


interface FileReader {
   suspend fun readFrom(file: String): String
}


class FileReaderService : FileReader {
    override suspend fun readFrom(file: String): String {
        return File(file).readText()
    }
}