package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.CourtPaymentEntity;

public interface CourtPaymentRepository extends CrudRepository<CourtPaymentEntity, Long> {
}