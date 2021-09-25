package com.example.cleanarch

interface UseCase<R> : Cancelable{
    fun execute() : R
}

interface Cancelable  {
    fun cancel()
}