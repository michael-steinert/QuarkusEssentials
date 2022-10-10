package org.acme.services

import org.acme.models.ClientDetails
import org.acme.repositories.ClientDetailsRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
class ClientDetailsService {
    @Inject
    lateinit var clientDetailsRepository: ClientDetailsRepository

    fun persistClientDetails(clientDetails: ClientDetails) {
        clientDetailsRepository.persist(clientDetails)
    }

    fun listAllClientDetails(): List<ClientDetails> {
        return clientDetailsRepository.listAll()
    }

    fun findByIdClientDetails(id: Long): ClientDetails? {
        return clientDetailsRepository.findById(id)
    }

    fun findByNameClientDetails(name: String): ClientDetails? {
        return clientDetailsRepository.findByName(name)
    }

    fun deleteClientDetails(id: Long): Boolean {
        return clientDetailsRepository.deleteById(id)
    }

    fun updateClientDetails(clientDetails: ClientDetails): Int {
        return clientDetailsRepository.update(
            "name='${clientDetails.name}'," + "surname='${clientDetails.surname}'," + "age ='${clientDetails.age}'," + "email='${clientDetails.email}'," + "basicSalary='${clientDetails.basicSalary}'" + "where id =${clientDetails.id}"
        )
    }
}