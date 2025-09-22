package edu.iesam.studentplayground.features.students.domain

interface StudentRepository {

    //Si no lo especificamos es :Unit (que seria como void en java)
    fun save(student: Student)

}