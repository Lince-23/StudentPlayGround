package edu.iesam.studentplayground.features.students.data

import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StudentDataRepositoryTest {
    @RelaxedMockK
    lateinit var mockMemLocalDataSource: StudentMemLocalDataSource

    lateinit var studentDataRepository: StudentDataRepository

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        studentDataRepository = StudentDataRepository(
            StudentXmlLocalDataSource(),
            mockMemLocalDataSource,
            StudentApiRemoteDataSource()
        )
    }

    @Test
    fun `save a student`(){
        //Given
        val student = Student("0000", "Name")
        //When
        studentDataRepository.save(student)
        //Then
        verify(exactly = 1) { mockMemLocalDataSource.save(student) }
    }

    @Test
    fun `get the student list`(){
        //Given
        val expectedList =listOf<Student>(Student("0000", "Name"))
        every { mockMemLocalDataSource.get() } returns expectedList
        //When
        val result = studentDataRepository.get()
        //Then
        assertEquals(expectedList, result)
        verify(exactly = 1) { mockMemLocalDataSource.get() }
    }

    @Test
    fun `delete a student with the exp`(){
        //Given
        val exp = "0000"
        //When
        studentDataRepository.delete(exp)
        //Then
        verify(exactly = 1) { mockMemLocalDataSource.delete(exp) }
    }
}