package com.moaimar.custom_newspaper.app.domain

sealed class ErrorApp {
    object DataLayerError : ErrorApp()
    object NoInternetError: ErrorApp()
    object TimeOutError: ErrorApp()
    object UnKnowError: ErrorApp()

}