package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {

    //Si no lo especificamos es :Unit (que seria como void en java)
    fun save(student: Student)

    fun findAll(): List<Student>

    fun getStudent(exp: String): Student?

    fun delete(exp: String)

    fun update(exp: String, changeStudent: Student)

}