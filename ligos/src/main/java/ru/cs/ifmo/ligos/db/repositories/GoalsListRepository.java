package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.GoalsListEntity;

public interface GoalsListRepository extends CrudRepository<GoalsListEntity, Long> {
}