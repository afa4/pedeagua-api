package br.com.pedeagua.api.entity.dto

class DistributorRequest(val name: String,
                         val cnpj: String,
                         val mail: String,
                         val password: String,
                         val address: AddressDTO,
                         val phones: List<PhoneDTO>) {
    class AddressDTO(val street: String,
                     val number: String,
                     val complement: String?,
                     val zipCode: String,
                     val neighbourhood: String)

    class PhoneDTO(val ddd: String,
                   val number: String)
}