package com.github.jlgrock.autograder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
interface CourseRepository extends JpaRepository<Course, Long> {
}
