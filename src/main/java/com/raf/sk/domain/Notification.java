package com.raf.sk.domain;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Data
@Table
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String mail;
    @ManyToOne(optional = false)
    private Type type;
    private String body;
    private String time;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public Notification(String mail, Type type, String body, String time) {
        this.mail = mail;
        this.type = type;
        this.body = body;
        this.time = time;
    }

    public Notification() {

    }
}
