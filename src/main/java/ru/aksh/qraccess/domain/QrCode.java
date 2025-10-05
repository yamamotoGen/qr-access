package ru.aksh.qraccess.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "qr_code")
public class QrCode {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "qr_uuid")
    private UUID uuid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private User user;

    public QrCode() {
    }

    public QrCode(UUID uuid, User user) {
        this.uuid = uuid;
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
