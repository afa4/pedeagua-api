package br.com.pedeagua.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PedeaguaApiApplication

fun main(args: Array<String>) {
	runApplication<PedeaguaApiApplication>(*args)
}
