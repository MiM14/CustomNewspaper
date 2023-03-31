package com.moaimar.custom_newspaper.app.domain

sealed class ErrorApp {
    class DataError() : ErrorApp()
    class DomainError() : ErrorApp()
}