package com.github.jlgrock.autograder.domain
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.validation.constraints.NotNull
import java.time.LocalDateTime
/**
 *
 */
@MappedSuperclass
class AbstractEntity {
    @Id
    @GeneratedValue
    Long id

    @CreatedDate
    @NotNull
    LocalDateTime createdDate

    @LastModifiedDate
    @NotNull
    LocalDateTime modifiedDate
}
