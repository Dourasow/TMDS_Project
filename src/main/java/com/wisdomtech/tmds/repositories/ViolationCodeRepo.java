package com.wisdomtech.tmds.repositories;

import com.wisdomtech.tmds.models.ViolationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationCodeRepo extends JpaRepository<ViolationCode, Long> {
}
