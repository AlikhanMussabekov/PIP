package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.CourtReviewsEntity;

public interface CourtReviewsRepository extends CrudRepository<CourtReviewsEntity, Long> {
}