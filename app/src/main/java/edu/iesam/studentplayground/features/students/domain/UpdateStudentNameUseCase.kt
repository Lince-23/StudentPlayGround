package edu.iesam.studentplayground.features.students.domain

class UpdateStudentNameUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(exp:String, changeStudent: Student){
        studentRepository.updateName(exp, changeStudent)
    }
}