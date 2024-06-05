package com.example.todo.services

import com.example.todo.model.FormState

interface Validator {
    fun validate(form: FormState): Boolean
}

class ValidatorService: Validator {
    override fun validate(form: FormState): Boolean {
        return form.content.isNotBlank()
    }
}