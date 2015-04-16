package com.github.jlgrock.autograder.controllers
import com.github.jlgrock.autograder.domain.Course
import com.github.jlgrock.autograder.domain.CourseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject
/**
 *
 */
@RestController
@RequestMapping("courses")
class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    CourseRepository courseRepository

    @Inject
    CourseController(CourseRepository courseRepositoryIn) {
        courseRepository = courseRepositoryIn
    }

//    @RequestMapping(value="", method=RequestMethod.GET)
//    List<Course> getCourses() {
//        LOGGER.trace("getCourses");
//        courseRepository.findAll();
//    }

    /**
     * 200 (OK), single customer. 404 (Not Found), if ID not found or invalid.
     * @param id
     * @return
     */
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    Course getCourse(@PathVariable("id") Long id) {
        LOGGER.trace("getCourse for id {}", id);
        courseRepository.findOne(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.POST)
    void saveCourse(@PathVariable("id") Long id) {
        LOGGER.trace("saveCourse for id {}", id);
    }

    /**
     * Delete
     * 200 (OK). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    void deleteCourse(@PathVariable("id") Long id) {
        LOGGER.trace("deleteCourse for id {}", id);
    }

    /**
     * Update
     * 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    void updateCourse(@PathVariable("id") Long id) {
        LOGGER.trace("updateCourse for id {}", id);
        //TODO
    }

//    /**
//     * Get the students by course
//     * @param courseId
//     */
//    @RequestMapping(value="{id}/students", method=RequestMethod.GET)
//    void getStudents(@PathVariable("id") Long id) {
//        LOGGER.trace("getStudents for id {}", id);
//        getCourse(id).getStudents()
//    }
//
//    @RequestMapping(value="{id}/instructors", method=RequestMethod.GET)
//    List<User> getInstructor(@PathVariable("id") Long id) {
//        LOGGER.trace("getInstructor for id {}", id);
//        getCourse(id).getInstructor() + getCourse(id).getTeachingAssistants()
//    }
//
//    @RequestMapping(value="{id}/lectures", method=RequestMethod.GET)
//    List<Lecture> getLectures(@PathVariable("id") Long id) {
//        LOGGER.trace("getLectures for id {}", id);
//        getCourse(id).getLectures()
//    }
}
