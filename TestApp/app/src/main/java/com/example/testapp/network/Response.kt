package com.example.testapp.network

sealed class Response() {
    data class Progress(val status: Int): Response()
    data class Success(val data: String, val status: Int): Response()
    data class Failure(val errorMessage: String, val status: Int): Response()
}

class ResponseHandler(){
    fun parseResponse(status: Int, data: String?) = when(status){
        200 -> {
            Response.Success(data?:"success", status)
        }
        202 -> {
            Response.Progress(status)
        }
        401, 404, 500 -> {
            Response.Failure(data?:"error", status)
        }
        else -> {Response.Failure(data?:"error", status)}
    }
}

