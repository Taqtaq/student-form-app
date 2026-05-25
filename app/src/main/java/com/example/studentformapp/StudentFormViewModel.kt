// StudentFormViewModel.kt
package com.example.studentformapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class StudentFormState(
    val nameState: String = "",
    val emailState: String = "",
    val dateState: String = "",
    val selectedOption: String = "",
    val isAgreed: Boolean = false
)

class StudentFormViewModel : ViewModel() {
    private val _formState = MutableStateFlow(StudentFormState())
    val formState: StateFlow<StudentFormState> = _formState.asStateFlow()

    fun updateName(name: String) {
        _formState.value = _formState.value.copy(nameState = name)
    }

    fun updateEmail(email: String) {
        _formState.value = _formState.value.copy(emailState = email)
    }

    fun updateDate(date: String) {
        _formState.value = _formState.value.copy(dateState = date)
    }

    fun updateSelectedOption(option: String) {
        _formState.value = _formState.value.copy(selectedOption = option)
    }

    fun updateAgreement(agreed: Boolean) {
        _formState.value = _formState.value.copy(isAgreed = agreed)
    }

    fun validateForm(): Boolean {
        val state = _formState.value
        return state.nameState.isNotBlank() &&
                state.emailState.isNotBlank() &&
                state.dateState.isNotBlank() &&
                state.selectedOption.isNotBlank() &&
                state.isAgreed
    }
}
