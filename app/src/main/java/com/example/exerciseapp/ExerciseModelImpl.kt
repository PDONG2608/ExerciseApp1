package com.example.exerciseapp

class ExerciseModelImpl: ExerciseContract.ExerciseModel {
    override fun getExerciseList(): List<Exercise> {
       return listOf(
           Exercise("Are you Ready?", 4, R.drawable.areyouready,"Are you Ready"),
           Exercise("Push-up", 11, R.drawable.chongday,"Exercise 1: Push up"),
           Exercise("Rest", 11, R.drawable.img_4,"Take a break"),
           Exercise("Pull up bar", 11, R.drawable.img_5,"Exercise 2: Pull up bar "),
           Exercise("Rest", 11, R.drawable.img_4,"Take a break"),
           Exercise("Leg exercises", 11, R.drawable.img_6,"Exercise 3: Leg exercises"),
           Exercise("Amazing gutchop anh!", 11, R.drawable.img_7,"amazing, good job ")
       )
    }
}