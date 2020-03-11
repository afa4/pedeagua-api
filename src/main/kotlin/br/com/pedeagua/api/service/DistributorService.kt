package br.com.pedeagua.api.service

import br.com.pedeagua.api.dao.Phones
import br.com.pedeagua.api.entity.Address
import br.com.pedeagua.api.entity.Distributor
import br.com.pedeagua.api.entity.User
import br.com.pedeagua.api.entity.dto.DistributorRequest
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class DistributorService(val passwordEncoder: PasswordEncoder) {

    fun create(distributorDto: DistributorRequest) {
        transaction {
            val persistedUser = User.new {
                username = distributorDto.mail
                password = passwordEncoder.encode(distributorDto.password)
            }

            val persistedAddress = Address.new {
                street = distributorDto.address.street
                number = distributorDto.address.number
                neighbourhood = distributorDto.address.neighbourhood
                zipCode = distributorDto.address.zipCode
                complement = distributorDto.address.complement
            }

            Phones.batchInsert(distributorDto.phones) { phoneDto ->
                this[Phones.ddd] = phoneDto.ddd
                this[Phones.number] = phoneDto.number
                this[Phones.user] = persistedUser.id
            }

            Distributor.new {
                name = distributorDto.name
                email = distributorDto.mail
                cnpj = distributorDto.cnpj
                user = persistedUser
                address = persistedAddress
            }
        }
    }
}