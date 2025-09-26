package edu.iesam.studentplayground.features.students.data.local

import edu.iesam.studentplayground.features.students.domain.Student

class StudentMemLocalDataSource {

    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource.put(student.exp, student)
    }

    fun findAll(): List<Student> {
        return dataSource.map { student ->
            student.value
        }
    }

    fun delete(exp: String) {
        dataSource.remove(exp)
    }

    fun update(exp: String, updatedStudent: Student) {
        dataSource.replace(exp, dataSource.get(exp)!!, updatedStudent)
    }

    fun getStudent(exp: String): Student? {
        return dataSource.get(exp)
    }
}