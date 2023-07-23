package com.example.exerciseapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), ExerciseContract.View, TextToSpeech.OnInitListener {
    private lateinit var presenter: ExerciseContract.Presenter
    private lateinit var tvExerciseName: TextView
    private lateinit var ivExerciseImage: ImageView
    private lateinit var tvExerciseTimer: TextView
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button
    private lateinit var btnReset: Button
    lateinit var textToSpeech: TextToSpeech
    private lateinit var mediaPlayer: MediaPlayer
    private var isMusicPlaying = false
    private var isSpeaking = false

    private val model: ExerciseContract.ExerciseModel =
        ExerciseModelImpl() // Khởi tạo đối tượng ExerciseModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ExcercisePresenter(this,model)
        textToSpeech = TextToSpeech(this, this)

        tvExerciseName = findViewById(R.id.tvExerciseName)
        ivExerciseImage = findViewById(R.id.ivExerciseImage)
        tvExerciseTimer = findViewById(R.id.tvExerciseTimer)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnReset = findViewById(R.id.btnReset)

        mediaPlayer = MediaPlayer.create(this,R.raw.music)
        mediaPlayer.isLooping = true
        mediaPlayer.setVolume(0.5f,0.5f)

        tvExerciseName.text = "Exercise App"
        ivExerciseImage.setImageResource(R.drawable.mainimage)
        //Nut Start
        btnStart.setOnClickListener {
            if(!isMusicPlaying ||(isMusicPlaying && !mediaPlayer.isPlaying)){
                mediaPlayer.start()
                isMusicPlaying = true
                presenter.startExercise()
            }
        }
        //Nut Stop
        btnStop.setOnClickListener {
            if(isMusicPlaying && mediaPlayer.isPlaying){
                mediaPlayer.pause()
                isMusicPlaying = false
                tvExerciseTimer.text = ""
                presenter.stopExercise()
            }
        }
        //Nut Reset
        btnReset.setOnClickListener {
            presenter.stopExercise()
        }
    }

    override fun displayExercise(exercise: Exercise) {
        tvExerciseName.text = exercise.name
        ivExerciseImage.setImageResource(exercise.imageResId)
        textToSpeech.speak(exercise.description, TextToSpeech.QUEUE_FLUSH,null, null)
    }

    override fun displayExerciseTime(time: String) {
        tvExerciseTimer.text = time
//        if(time.isNotEmpty() && time != "0"){
//            val seconds = time.toInt()
//            if(seconds > 0){
//                textToSpeech.speak(time, TextToSpeech.QUEUE_FLUSH, null, null)
//            }
//        }
    }

    override fun displayNextExercise() {
        tvExerciseTimer.text = "0"
        presenter.startExercise()
    }

    override fun displayExerciseComplete() {
        tvExerciseName.text = "COMPLETE!"
        ivExerciseImage.setImageResource(R.drawable.img_3)
        tvExerciseTimer.text = ""
    }

    override fun getModel(): ExerciseContract.ExerciseModel {
        return model
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.ENGLISH)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("phuongdong", "Language no supported")
            } else {
                textToSpeech.setSpeechRate(1.1f)
                textToSpeech.setPitch(1.0f)
            }
        } else {
            Log.e("phuongdong", "Init Fail")
        }
    }

    override fun onPause() {
        super.onPause()
        if(isMusicPlaying && mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }
        if(isSpeaking && textToSpeech.isSpeaking){
            textToSpeech.stop()
            isSpeaking = false
        }

    }

    override fun onResume() {
        super.onResume()
        if(isMusicPlaying){
            mediaPlayer.start()
        }
        if(!isSpeaking && !textToSpeech.isSpeaking){
            isSpeaking = true
        }
    }

    override fun onDestroy() {
        textToSpeech.stop()
        textToSpeech.shutdown()
        mediaPlayer.stop()
        super.onDestroy()
    }
}