package com.github.jlgrock.autograder.domain
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.NotBlank
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import java.time.LocalDate
/**
 *
 */
@Entity
@Table(name="HOMEWORKS")
@ToString
@EqualsAndHashCode
class Homework extends AbstractEntity {
    @NotNull
    @NotBlank
    @Column(name="NAME")
    @Size(max=100)
    String name;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Future
    LocalDate dueDate;
}
