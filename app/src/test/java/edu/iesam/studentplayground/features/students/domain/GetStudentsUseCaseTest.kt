package edu.iesam.studentplayground.features.students.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class GetStudentsUseCaseTest {
    @RelaxedMockK
    lateinit var mockStudentRepository: StudentRepository

    lateinit var getStudentsUseCase: GetStudentsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getStudentsUseCase = GetStudentsUseCase(mockStudentRepository)
    }

    @Test
    fun `get correctly the studentsRepository list`() {
        getStudentsUseCase.invoke()
        verify(exactly = 1) { mockStudentRepository.get() }
    }
}