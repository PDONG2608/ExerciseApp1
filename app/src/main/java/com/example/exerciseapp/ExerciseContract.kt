package com.example.exerciseapp

interface ExerciseContract {
    interface ExerciseModel {
        fun getExerciseList(): List<Exercise>
    }

    interface View {
        fun displayExercise(exercise: Exercise)
        fun displayExerciseTime(time: String)
        fun displayNextExercise()
        fun displayExerciseComplete()
        fun getModel(): ExerciseModel
    }

    interface Presenter {
        fun startExercise()
        fun stopExercise()
        fun resetExercise()
    }

}