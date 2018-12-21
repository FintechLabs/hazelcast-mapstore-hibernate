package com.fintechlabs.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "person_domain")
public class PersonDomainHazel implements Serializable {

    private static final long serialVersionUID = 6832006422622219737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "version", nullable = false)
    private Long version;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "unique_id", nullable = false)
    private String uniqueId = UUID.randomUUID().toString();
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;
    @Column(name = "last_updated", nullable = false)
    private Date lastUpdated;

}
