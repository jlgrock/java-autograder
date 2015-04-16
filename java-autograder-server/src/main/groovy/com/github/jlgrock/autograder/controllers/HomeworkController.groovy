package com.github.jlgrock.autograder.controllers
import com.github.jlgrock.autograder.domain.Homework
import com.github.jlgrock.autograder.domain.HomeworkRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.PathParam
/**
 *
 */
@RestController
@RequestMapping("homeworks")
class HomeworkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeworkController.class);

    HomeworkRepository homeworkRepository

    @Inject
    HomeworkController(HomeworkRepository homeworkRepositoryIn) {
        LOGGER.trace("" + homeworkRepositoryIn);
        assert homeworkRepositoryIn != null
        homeworkRepository = homeworkRepositoryIn
    }


    /**
     * 200 (OK), single customer. 404 (Not Found), if ID not found or invalid.
     * @param id
     * @return
     */
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    Homework getHomework(@PathVariable("id") Long id) {
        LOGGER.trace("getHomework for id {}", id)
        Homework homework = homeworkRepository.findOne(id)
        LOGGER.trace("homework={}", homework)
        homework
    }

    @RequestMapping(value="{id}", method=RequestMethod.POST)
    void addHomework(@RequestBody @Valid final Homework homework) {
        LOGGER.trace("addHomework for homework {}", homework)
        updateHomework(homework)
    }

    /**
     * Delete
     * 200 (OK). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    void deleteHomework(@PathParam("id") Long id) {
        LOGGER.trace("deleteHomework for id {}", id)
        homeworkRepository.delete(id)
    }

    /**
     * Update
     * 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid.
     */
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    void updateHomework(@RequestBody @Valid final Homework homework) {
        LOGGER.trace("updateHomework for homework {}", homework)
        homeworkRepository.save(homework)
    }

}
