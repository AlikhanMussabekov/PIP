package ru.cs.ifmo.ligos.db.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.cs.ifmo.ligos.db.entities.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
}