package br.com.pedeagua.api.controller

import br.com.pedeagua.api.entity.dto.DistributorRequest
import br.com.pedeagua.api.service.DistributorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/distributors")
class DistributorController(val distributorService: DistributorService) {

    @PostMapping
    fun create(@RequestBody distributorDto: DistributorRequest): ResponseEntity<Any> {
        distributorService.create(distributorDto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}
