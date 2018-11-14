package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.SectionUsersEntity;

public interface SectionUsersRepository extends CrudRepository<SectionUsersEntity, Long> {
}