package com.raf.sk.repository;

import com.raf.sk.domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    Page<Notification> findAllByMail(String mail, Pageable pageable);
    Page<Notification> findAllByTime(String startDate,String endDate,Pageable pageable);

}
