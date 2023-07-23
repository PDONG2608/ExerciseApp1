package com.example.exerciseapp

import android.os.CountDownTimer
import android.util.Log

class ExcercisePresenter(
    private val view: ExerciseContract.View,
    private val exercises: ExerciseContract.ExerciseModel,
) :
    ExerciseContract.Presenter {
    private var exerciseTimer: CountDownTimer? = null
    private var exerciseIndex = 0;
    override fun startExercise() {
        Log.d("phuongdong", "startExercise")
        val exerciseList = view.getModel().getExerciseList()
        if (exerciseIndex < exerciseList.size) {
            val exercise = exerciseList[exerciseIndex]
            if(exerciseIndex  %2 == 0){
                for(i in 0 until 3){
                    view.displayExercise(exercise)
                }
            }
            view.displayExercise(exercise)

            exerciseTimer = object : CountDownTimer((exercise.duration * 1000).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val secondRemaining = millisUntilFinished / 1000
                    view.displayExerciseTime(secondRemaining.toString())
                }

                override fun onFinish() {
                    exerciseIndex++
                    if (exerciseIndex < exerciseList.size) {
                        view.displayNextExercise()
                    } else {
                        view.displayExerciseComplete()
                    }
                }
            }.start()
        }
    }

    override fun stopExercise() {
        exerciseTimer?.cancel()
        view.displayExerciseTime("0")
    }

    override fun resetExercise() {
        exerciseIndex = 0;
        exerciseTimer?.cancel()
        view.displayExerciseTime("0")
        view.displayExerciseComplete()
    }
}
