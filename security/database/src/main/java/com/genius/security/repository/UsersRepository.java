package com.genius.security.repository;

import com.genius.security.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByName(String username);
}
