package com.raf.sk.repository;

import com.raf.sk.domain.MailType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<MailType,Long> {

}
