package com.github.jlgrock.autograder.domain
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Future
import java.time.LocalDateTime
/**
 *
 */
@Entity
@Table(name="LECTURES")
@ToString
@EqualsAndHashCode
class Lecture extends AbstractEntity {

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Future
    LocalDateTime dateOfClass
    // TODO I assume this will need some form of reading material, video content, quizes, and link to a homework
}
