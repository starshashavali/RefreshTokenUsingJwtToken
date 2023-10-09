package com.org.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.domain.RefreshToken;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer> {
	Optional<RefreshToken> findByToken(String token);
}
