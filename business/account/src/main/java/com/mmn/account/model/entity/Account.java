package com.mmn.account.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mmn.account.model.Address;
import com.mmn.account.model.type.AccountStatus;
import com.mmn.account.model.type.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table(indexes = {
        @Index(columnList = "INVITE_TOKEN", unique = true),
        @Index(columnList = "EMAIL", unique = true),
        @Index(columnList = "PHONE", unique = true)
})
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length = 36)
    private String id;
    /* Login by either to or phone,
        but to is mandatory! */
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;

    @Column(updatable = false)
    private String password;
    private String resetToken;
    @Column(name = "INVITE_TOKEN")
    private String inviteToken;

    // Additional fields
    private String name;
    private String lastName;
    @Embedded
    private Address address;
    private Date birthDate;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.CLIENT;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.New;
    @Builder.Default
    private LocalDate creationDate = LocalDate.now();
    private LocalDate updatedDate;

    private Boolean acceptedTerms = true;
    private Boolean newsletterEnabled = true;
    private Boolean paymentActive = false;

    public static void main(String[] args) {
//        System.out.println("ID -> " + UUID.randomUUID().toString());
        System.out.println("inviteToken -> " + Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes()));
//        System.out.println("resetToken -> " + Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes()));
    }

    public Account confirmed() {
        setAccountStatus(AccountStatus.Authenticated);
        setUpdatedDate(LocalDate.now());
        return this;
    }

    public Account newTokens() {
        if (Objects.isNull(getResetToken())) {
            updateToken();
        }
        if (Objects.isNull(getInviteToken())) {
            setInviteToken(base64Enconder());
        }
        return this;
    }

    public Account updateToken() {
        setResetToken(base64Enconder());
        return this;
    }

    private String base64Enconder() {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }

    public Account hidePassAndToken() {
        setPassword(null);
        setResetToken(null);
        return this;
    }

    public boolean isAdmin() {
        try {
            return this.role.equals(RoleEnum.ADMIN);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isinvestor() {
        try {
            return this.role.equals(RoleEnum.INVESTOR);
        } catch (Exception e) {
            return false;
        }
    }

    public Account treeInfo() {
        return Account.builder()
                .id(this.getId())
                .name(this.getName())
                .lastName(this.getLastName())
                .email(this.getEmail())
                .accountStatus(this.getAccountStatus())
                .role(this.getRole())
                .build();
    }
}
