package com.github.jlgrock.autograder.domain

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.time.LocalDateTime

/**
 *
 */
@Converter(autoApply = true)
class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, java.sql.Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
        entityValue ? java.sql.Timestamp.valueOf(entityValue) : null
    }

    @Override
    public LocalDateTime convertToEntityAttribute(java.sql.Timestamp databaseValue) {
        databaseValue?.toLocalDateTime()
    }
}
