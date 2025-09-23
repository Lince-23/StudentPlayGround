package edu.iesam.studentplayground.features.students.domain

import android.util.Log

class UpdateStudentNameUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(exp:String, changeStudent: Student){
        val existingStudent: Student? = studentRepository.getStudent(exp)

        if(existingStudent != null) {
            studentRepository.update(exp, changeStudent)
        }else{
            Log.d("@dev", "El usuario que se intenta actualizar no existe")
        }
    }
}