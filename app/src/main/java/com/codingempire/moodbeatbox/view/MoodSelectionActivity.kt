package com.codingempire.moodbeatbox.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingempire.moodbeatbox.databinding.ActivityMoodSelectionBinding
import com.codingempire.moodbeatbox.utils.Constants

class MoodSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoodSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoodSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHappy.setOnClickListener {
            goToMusicScreen("Happy")
        }

        binding.btnSad.setOnClickListener {
            goToMusicScreen("Sad")
        }

        binding.btnEnergetic.setOnClickListener {
            goToMusicScreen("Energetic")
        }

        binding.btnCalm.setOnClickListener {
            goToMusicScreen("Calm")
        }
    }

    private fun goToMusicScreen(mood: String) {
        Toast.makeText(this, "$mood mood selected", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MusicPlayerActivity::class.java)
        intent.putExtra(Constants.EXTRA_SELECTED_MOOD, mood)
        startActivity(intent)
    }
}
