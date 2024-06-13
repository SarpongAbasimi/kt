package com.example.moviedb.container

import com.example.moviedb.service.FileReader
import com.example.moviedb.service.FileReaderService

interface Container {
    val fileReader: FileReader
}

object DefaultContainer : Container {
    override val fileReader: FileReader = FileReaderService()
}