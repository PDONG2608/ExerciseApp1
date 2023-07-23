package com.example.exerciseapp

class ExerciseModelImpl: ExerciseContract.ExerciseModel {
    val MAX_SECOND = 6
    override fun getExerciseList(): List<Exercise> {
       return listOf(
           Exercise("Are you Ready?", 4, R.drawable.areyouready,"Are you Ready"),
           Exercise("Push-up", MAX_SECOND, R.drawable.chongday,"Exercise 1: Push up, sec 1"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Push-up", MAX_SECOND, R.drawable.chongday,"sec 2"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Push-up", MAX_SECOND, R.drawable.chongday,"sec 3"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Pull up bar", MAX_SECOND, R.drawable.img_5,"Exercise 2,Pull up bar, sec 1 "),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Pull up bar", MAX_SECOND, R.drawable.img_5,"sec 2"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Pull up bar", MAX_SECOND, R.drawable.img_5,"sec 3"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Leg exercises", MAX_SECOND, R.drawable.img_6,"Exercise 3,Leg exercises,sec 1"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Leg exercises", MAX_SECOND, R.drawable.img_6,"sec 2"),
           Exercise("Rest", MAX_SECOND, R.drawable.img_4,"Take a break"),
           Exercise("Leg exercises", MAX_SECOND, R.drawable.img_6,"sec 3"),
           Exercise("Amazing gutchop anh!", MAX_SECOND, R.drawable.img_7,"amazing, good job ")
       )
    }
}