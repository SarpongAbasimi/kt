package com.example.moviedb.container

import com.example.moviedb.service.FileReader
import com.example.moviedb.service.FileReaderService
import com.example.moviedb.service.TransformerService

interface Container {
    val fileReader: FileReader
    val transformer: TransformerService
}

object DefaultContainer : Container {
    override val fileReader: FileReader = FileReaderService()
    override val transformer: TransformerService = TransformerService()
}