package com.shieldme.authentication.repository;

import com.shieldme.authentication.entity.ForgotPassword;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForgotPasswordRepository extends MongoRepository<ForgotPassword, String> {

    Optional<ForgotPassword> findByOtpAndUserId(Integer otp, String userId);
}
