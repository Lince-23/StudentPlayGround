package edu.iesam.studentplayground.features.students.domain

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class UpdateStudentNameUseCaseTest {
    @RelaxedMockK
    lateinit var mockStudentRepository: StudentRepository

    lateinit var updateStudentNameUseCase: UpdateStudentNameUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        updateStudentNameUseCase = UpdateStudentNameUseCase(mockStudentRepository)
    }

    @Test
    fun `update an existing user`(){
        //Given
        val student = Student("0000", "Name")
        every { mockStudentRepository.getStudent(student.exp) } returns student
        //When
        updateStudentNameUseCase.invoke(student.exp, student)
        //Then
        verify(exactly = 1) { mockStudentRepository.update(student.exp, student) }
    }

    @Test
    fun `try to update an unexisting user`(){
        //Given
        val student = Student("0000", "Name")
        every { mockStudentRepository.getStudent(student.exp) } returns null
        //When
        updateStudentNameUseCase.invoke(student.exp, student)
        //Then
        verify(exactly = 0) { mockStudentRepository.update(student.exp, student) }
    }
}