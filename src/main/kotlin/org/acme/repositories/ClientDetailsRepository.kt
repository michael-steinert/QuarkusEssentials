package org.acme.repositories

import io.quarkus.hibernate.orm.panache.PanacheRepository
import org.acme.models.ClientDetails
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ClientDetailsRepository : PanacheRepository<ClientDetails> {
    fun findByName(name: String): ClientDetails? = find("name", name).firstResult<ClientDetails>()
}