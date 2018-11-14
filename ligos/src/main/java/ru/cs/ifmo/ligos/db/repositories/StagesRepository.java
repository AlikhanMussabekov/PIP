package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.StagesEntity;

public interface StagesRepository extends CrudRepository<StagesEntity, Long> {
}