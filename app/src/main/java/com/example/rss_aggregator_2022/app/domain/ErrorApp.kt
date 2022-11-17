package com.example.rss_aggregator_2022.app.domain

sealed class ErrorApp {
    class DataError() : ErrorApp()
    class DomainError() : ErrorApp()
}