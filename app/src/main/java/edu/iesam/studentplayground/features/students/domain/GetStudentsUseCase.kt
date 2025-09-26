package edu.iesam.studentplayground.features.students.domain

class GetStudentsUseCase(private val studentRepository: StudentRepository) {

    operator fun invoke(): List<Student>{
        return studentRepository.findAll()
    }

}