package edu.iesam.studentplayground.features.students.data

import edu.iesam.studentplayground.features.students.data.local.StudentMemLocalDataSource
import edu.iesam.studentplayground.features.students.data.local.StudentXmlLocalDataSource
import edu.iesam.studentplayground.features.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.StudentRepository

class StudentDataRepository(
    private val xmlLocalDataSource: StudentXmlLocalDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val apiRemoteDataSource: StudentApiRemoteDataSource
) : StudentRepository {

    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }

    override fun findAll(): List<Student> {
        return memLocalDataSource.findAll()
    }

    override fun delete(exp: String) {
        memLocalDataSource.delete(exp)
    }

    override fun update(exp: String, changeStudent: Student) {
        memLocalDataSource.update(exp, changeStudent)
    }

    override fun getStudent(exp: String): Student? {
        return memLocalDataSource.getStudent(exp)
    }
}