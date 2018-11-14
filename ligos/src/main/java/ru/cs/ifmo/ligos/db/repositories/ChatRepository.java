package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.ChatEntity;

public interface ChatRepository extends CrudRepository<ChatEntity, Long> {
}