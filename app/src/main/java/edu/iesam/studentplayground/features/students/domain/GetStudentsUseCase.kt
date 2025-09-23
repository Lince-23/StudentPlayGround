package edu.iesam.studentplayground.features.students.domain

class GetStudentsUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(){
        studentRepository.get()
    }

}