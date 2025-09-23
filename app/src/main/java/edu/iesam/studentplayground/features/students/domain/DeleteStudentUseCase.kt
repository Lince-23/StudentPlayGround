package edu.iesam.studentplayground.features.students.domain

import android.util.Log

class DeleteStudentUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(exp:String){
        val existingStudent: Student? = studentRepository.getStudent(exp)

        if(existingStudent != null) {
            studentRepository.delete(exp)
        }else{
//            Log.d("@dev", "El usuario que se intenta eliminar no existe")
        }
    }
}