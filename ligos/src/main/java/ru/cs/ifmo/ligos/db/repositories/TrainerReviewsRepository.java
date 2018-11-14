package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.TrainerReviewsEntity;

public interface TrainerReviewsRepository extends CrudRepository<TrainerReviewsEntity, Long> {
}