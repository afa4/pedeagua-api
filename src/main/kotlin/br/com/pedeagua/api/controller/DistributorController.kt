package br.com.pedeagua.api.controller

import br.com.pedeagua.api.entity.dto.DistributorRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/distributor")
class DistributorController {

    @PostMapping
    fun create(@RequestBody distributor: DistributorRequest): ResponseEntity<Any> =
            ResponseEntity.status(HttpStatus.CREATED).build()

}
