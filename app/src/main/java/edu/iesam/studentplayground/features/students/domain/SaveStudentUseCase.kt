package edu.iesam.studentplayground.features.students.domain

class SaveStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(student: Student) {
        if (student.exp.isNotEmpty() && student.name.isNotEmpty()) {
            studentRepository.save(student)
        }
    }

}