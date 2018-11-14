package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.OrganizationEntity;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {
}