package com.example.todo.services

interface Validator {
    fun validate(content: String): Boolean
}

class ValidatorService: Validator {
    override fun validate(content: String): Boolean {
        return content.isNotBlank()
    }
}