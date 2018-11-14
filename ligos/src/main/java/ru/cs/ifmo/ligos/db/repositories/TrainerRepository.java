package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TrainerEntity;

public interface TrainerRepository extends CrudRepository<TrainerEntity, Long> {
}