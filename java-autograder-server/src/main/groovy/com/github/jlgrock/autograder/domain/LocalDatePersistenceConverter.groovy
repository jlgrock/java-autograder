package com.github.jlgrock.autograder.domain

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.time.LocalDate

/**
 *
 */
@Converter(autoApply = true)
class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, java.sql.Date> {

    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        entityValue ? java.sql.Date.valueOf(entityValue) : null
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        databaseValue?.toLocalDate()
    }
}