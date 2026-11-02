package com.example

import com.example.data.EpsRepository
import com.example.model.ExamResult
import com.example.model.QuestionType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    private val repository = EpsRepository()

    @Test
    fun testBookLessonsLoaded() {
        val book1Lessons = repository.getLessonsByBook(1)
        val book2Lessons = repository.getLessonsByBook(2)

        assertTrue("Book 1 should have lessons", book1Lessons.isNotEmpty())
        assertTrue("Book 2 should have lessons", book2Lessons.isNotEmpty())

        val lesson41 = repository.getLessonById(41)
        assertNotNull("Lesson 41 (Tools) should be present", lesson41)
        assertEquals("제41과 펜치로 철사를 잘라요", lesson41?.koreanTitle)
    }

    @Test
    fun testVocabSearch() {
        val pliersSearch = repository.searchVocabularies("펜치")
        assertTrue("Should find 펜치 in vocabulary", pliersSearch.any { it.korean == "펜치" })

        val sinhalaSearch = repository.searchVocabularies("ප්ලයර්")
        assertTrue("Should find by Sinhala meaning", sinhalaSearch.isNotEmpty())
    }

    @Test
    fun testAudioTracksAvailability() {
        val audioTracks = repository.getAllAudioTracks()
        assertTrue("Audio tracks should be generated from dialogues", audioTracks.isNotEmpty())
    }

    @Test
    fun testMockExamPapers() {
        val examPapers = repository.modelExamPapers
        assertTrue("Should have model exam papers", examPapers.isNotEmpty())

        val paper1 = examPapers[0]
        assertEquals(1, paper1.paperNumber)
        assertTrue("Paper should have reading questions", paper1.questions.any { it.type == QuestionType.READING })
        assertTrue("Paper should have listening questions", paper1.questions.any { it.type == QuestionType.LISTENING })
    }
}
