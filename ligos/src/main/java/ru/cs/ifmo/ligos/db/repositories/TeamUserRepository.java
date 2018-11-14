package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TeamUserEntity;

public interface TeamUserRepository extends CrudRepository<TeamUserEntity, Long> {
}