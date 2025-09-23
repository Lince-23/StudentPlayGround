package edu.iesam.studentplayground.features.students.domain

class UpdateStudentNameUseCase(val studentRepository: StudentRepository) {
    operator fun invoke(exp:String, changeStudent: Student){
        val existingStudent: Student? = studentRepository.getStudent(exp)

        if(existingStudent != null) {
            studentRepository.update(exp, changeStudent)
        }
    }
}