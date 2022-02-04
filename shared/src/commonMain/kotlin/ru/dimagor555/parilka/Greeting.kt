package ru.dimagor555.parilka

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}