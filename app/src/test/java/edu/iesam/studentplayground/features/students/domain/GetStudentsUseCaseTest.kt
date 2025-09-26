package edu.iesam.studentplayground.features.students.domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class GetStudentsUseCaseTest {

    @Test
    fun `when invoke then recover the students in a list`(){
        //Given
        val expectedList = listOf<Student>(Student("0000", "Name"))
        val studentDataRepositoryMock = mockk<StudentRepository>()
        val getStudentsUseCase= GetStudentsUseCase(studentDataRepositoryMock)
        //When
        every { studentDataRepositoryMock.findAll() } returns expectedList
        val resultList = getStudentsUseCase.invoke()
        //Then
        assertEquals(expectedList, resultList)
        verify(exactly = 1) { studentDataRepositoryMock.findAll() }
    }

}