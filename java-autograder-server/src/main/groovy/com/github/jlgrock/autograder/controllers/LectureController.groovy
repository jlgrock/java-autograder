package com.github.jlgrock.autograder.controllers
import com.github.jlgrock.autograder.domain.Course
import com.github.jlgrock.autograder.domain.LectureRepository
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
@RequestMapping("lectures")
class LectureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LectureController.class);

    LectureRepository lectureRepository

    @Inject
    LectureController(LectureRepository lectureRepositoryIn) {
        lectureRepository = lectureRepositoryIn
    }

    /**
     * 200 (OK), single customer. 404 (Not Found), if ID not found or invalid.
     * @param id
     * @return
     */
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    Course getLecture(@PathVariable("id") Long id) {
        LOGGER.trace("getLecture for id {}", id)
        if (id == null) {
            return null
        }
        lectureRepository.findOne(id)
    }

    @RequestMapping(value="{id}", method=RequestMethod.POST)
    void saveLecture(@PathVariable("id") Long id) {
        LOGGER.trace("saveLecture for id {}", id)
    }

    /**
     * Delete
     * 200 (OK). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    void deleteLecture(@PathVariable("id") Long id) {
        LOGGER.trace("deleteLecture for id {}", id)
    }

    /**
     * Update
     * 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    void updateLecture(@PathVariable("id") Long id) {
        LOGGER.trace("updateLecture for id {}", id)
        //TODO
    }
}
