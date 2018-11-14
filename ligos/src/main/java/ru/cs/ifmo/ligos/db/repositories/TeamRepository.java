package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TeamEntity;

public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
}