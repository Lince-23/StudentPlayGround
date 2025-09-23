package edu.iesam.studentplayground.features.students.domain

import android.util.Log
import io.mockk.Awaits
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.just
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.unmockkStatic
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class DeleteStudentUseCaseTest {
    @RelaxedMockK
    lateinit var mockStudentRepository: StudentRepository

    lateinit var deleteStudentUseCase: DeleteStudentUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        deleteStudentUseCase = DeleteStudentUseCase(mockStudentRepository)
    }

    @Test
    fun `delete an existing student`(){
        //Given
        val exp = "0000"
        every { mockStudentRepository.getStudent(exp) } returns Student(exp, "name")
        //When
        deleteStudentUseCase.invoke(exp)
        //Then
        verify(exactly = 1) { mockStudentRepository.delete(exp) }
    }

    @Test
    fun `delete an unexisting student`(){
        //Given
        val exp = ""
        every { mockStudentRepository.getStudent(exp) } returns null
        //When
        deleteStudentUseCase.invoke(exp)
        //Then
        verify(exactly = 0) { mockStudentRepository.delete(exp) }
    }


}