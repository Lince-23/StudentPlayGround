package edu.iesam.studentplayground.features.students.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class SaveStudentUseCaseTest {
    @RelaxedMockK
    lateinit var mockStudentRepository: StudentRepository

    lateinit var saveStudentUseCase: SaveStudentUseCase


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        saveStudentUseCase = SaveStudentUseCase(mockStudentRepository)
    }

    @Test
    fun `try to save a valid student`() {
        //Given
        val student = Student("0001", "Jean Doe")
        //When
        saveStudentUseCase.invoke(student)
        //Then
        verify { mockStudentRepository.save(student) }
    }

    @Test
    fun `try to save a invalid student`() {
        //Given
        val student = Student("d", "")
        //When
        saveStudentUseCase.invoke(student)
        //Then
        verify(exactly = 0) { mockStudentRepository.save(student) }
    }
}