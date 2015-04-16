package com.github.jlgrock.autograder.domain

import org.springframework.data.jpa.repository.JpaRepository

/**
 *
 */
interface LectureRepository extends JpaRepository<Lecture, Long> {
}
