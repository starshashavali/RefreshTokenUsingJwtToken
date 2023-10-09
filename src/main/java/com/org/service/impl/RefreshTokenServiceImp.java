package com.org.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.domain.RefreshToken;
import com.org.repo.RefreshTokenRepo;
import com.org.repo.UserInfoRepo;

@Service
public class RefreshTokenServiceImp {

    @Autowired
    private RefreshTokenRepo refreshTokenRepository;
    
    @Autowired
    private UserInfoRepo userInfoRepository;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfoRepository.findByName(username).get())
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))//10
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

//fetch token baes on id
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

  //verifying expireToken 
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
        	refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

}
