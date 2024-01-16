package com.raf.sk.repository;

import com.raf.sk.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository
public interface MailRepository extends JpaRepository<Mail,Long> {


}
