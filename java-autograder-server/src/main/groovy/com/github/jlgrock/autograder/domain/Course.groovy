package com.github.jlgrock.autograder.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.*
import javax.validation.Valid

/**
 *
 */
@Entity
@Table(name="COURSES")
@ToString
@EqualsAndHashCode
class Course extends AbstractEntity {
    /**
     * All of the lectures that will take place.
     */
    @Valid
    @OneToMany
    @JoinColumn(name="LECTURE_ID")
    List<Lecture> lectures

    /**
     * Whether or not to send emails to everyone in the class regarding the lectures
     */
    Boolean lectureReminders = true

    /**
     * All of the homework assignments in a class
     */
    @Valid
    @OneToMany
    List<Homework> homeworks

    /**
     * Whether or not to send emails to everyone in the class regarding the homeworks
     */
    Boolean homeworkReminders = true

    /**
     * The primary instructor for the course.  In addition to having the ability to grade homeworks and
     * adjust the course settings, this user is responsible TODO
     */
    @Valid
    @OneToOne
    //@Column(name="INSTRUCTOR_USER_ID")
    User instructor

    /**
     * A number of users that have the ability to grade homeworks and adjust the course settings
     */
    @Valid
    @ManyToMany
    @JoinTable(
            name = "COURSE_ASSISTANTS",
            joinColumns =  @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ASSISTANT_USER_ID")
    )
    List<User> teachingAssistants

    // TODO need to add validation that student != instructor or teaching assistant
    @Valid
    @OneToMany
    List<User> students
}
