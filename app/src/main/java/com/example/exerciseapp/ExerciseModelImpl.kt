package com.example.exerciseapp

class ExerciseModelImpl: ExerciseContract.ExerciseModel {
    override fun getExerciseList(): List<Exercise> {
       return listOf(
           Exercise("Push-up", 20, R.drawable.chongday,"Làm tý chống đẩy nhể"),
           Exercise("Rest", 20, R.drawable.img_4,"Anh à hãy giãn cơ 1 tý nhé"),
           Exercise("Pull up bar", 20, R.drawable.img_5,"Đu càng 1 tay"),
           Exercise("Rest", 20, R.drawable.img_4,"Anh à hãy giãn cơ 1 tý nhé"),
           Exercise("Leg exercises", 20, R.drawable.img_6,"Làm tý chân đê"),
           Exercise("Amazing gutchop anh!", 20, R.drawable.img_7,"Anh tuyệt vời lắm đấy")
       )
    }
}