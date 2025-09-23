package edu.iesam.studentplayground.features.students.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.studentplayground.features.students.domain.DeleteStudentUseCase
import edu.iesam.studentplayground.features.students.domain.GetStudentsUseCase
import edu.iesam.studentplayground.features.students.domain.SaveStudentUseCase
import edu.iesam.studentplayground.features.students.domain.Student
import edu.iesam.studentplayground.features.students.domain.UpdateStudentNameUseCase

class StudentViewModel(
    private val saveStudentUseCase: SaveStudentUseCase,
    private val getStudentsUseCase: GetStudentsUseCase,
    private val deleteStudentUseCase: DeleteStudentUseCase,
    private val updateStudentNameUseCase: UpdateStudentNameUseCase
) : ViewModel() {

    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun getClicked() {
        getStudentsUseCase.invoke()
    }

    fun deleteClicked(exp: String) {
        deleteStudentUseCase.invoke(exp)
    }

    fun updateClicked(exp: String, newUserName: String) {
        updateStudentNameUseCase.invoke(exp, Student(exp, newUserName))
    }

}