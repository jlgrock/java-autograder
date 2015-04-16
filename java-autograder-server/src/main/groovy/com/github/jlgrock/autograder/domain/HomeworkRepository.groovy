package com.github.jlgrock.autograder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface HomeworkRepository extends JpaRepository<Homework, Long> {
}
