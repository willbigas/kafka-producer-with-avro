package br.com.willbigas.kafkaproducerwithavro.repositories;

import br.com.willbigas.kafkaproducerwithavro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
