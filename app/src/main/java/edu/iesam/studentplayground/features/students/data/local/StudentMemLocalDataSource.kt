package edu.iesam.studentplayground.features.students.data.local

import edu.iesam.studentplayground.features.students.domain.Student

class StudentMemLocalDataSource{

    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource.put(student.exp, student)
    }

    fun get(): List<Student> {
        val list: List<Student> = dataSource.values.toList()
        return list
    }

    fun delete(exp: String){
        dataSource.remove(exp)
    }

    fun update(exp: String, updatedStudent: Student){
        dataSource.replace(exp, dataSource.get(exp)!!, updatedStudent )
    }
}