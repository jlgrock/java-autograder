package com.github.jlgrock.autograder.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
/**
 *
 */
@Entity
@Table(name="USERS")
@ToString
@EqualsAndHashCode
class User extends AbstractEntity {

    @NotNull
    @NotBlank
    @Column(name="PASSWORD")
    String password

    @NotNull
    @NotBlank
    @Size(min=2, max=64)
    @Column(name="FIRST_NAME")
    String firstName

    @NotNull
    @NotBlank
    @Column(name="LAST_NAME")
    @Size(min=2, max=64)
    String lastName

    @NotNull
    @Size(min=4, max=128)
    @Email
    @Column(name="EMAIL")
    String email
}
