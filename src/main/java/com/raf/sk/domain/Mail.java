package com.raf.sk.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String content;
    private LocalDate timeofsending;
    @ManyToOne
    private MailType mailType;

    private String recieverMail;
}
