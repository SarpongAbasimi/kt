package com.example.moviedb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.moviedb.ApplicationContainer
import com.example.moviedb.service.FileReader
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class HomeViewModel(val fileReader: FileReader): ViewModel() {

    fun read(file: String): String {
        return runBlocking {
            val result: Deferred<String> = async { fileReader.readFrom(file)}
            result.await()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                 val container = (this[APPLICATION_KEY] as ApplicationContainer).container

                HomeViewModel(container.fileReader)
            }
        }
    }
}



//fun main(){
//    val fileReader = FileReaderService()
//    val homeViewModel = HomeViewModel(fileReader)
//    val path = "/Users/sarpongabasimi/Desktop/Projects/kotlin/moviedb/app/src/main/java/com/example/moviedb/dummy/movie.json"
//    val res = homeViewModel.read(path)
//     val json = Json { ignoreUnknownKeys = true }
//
//    val convert = Json.parseToJsonElement(res)
//    val decode = json.decodeFromJsonElement<PopularMovies>(convert)
//
//    println(decode)
//}
