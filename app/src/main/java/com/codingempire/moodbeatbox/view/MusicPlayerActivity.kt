package com.codingempire.moodbeatbox.view

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codingempire.moodbeatbox.R
import com.codingempire.moodbeatbox.data.model.Song
import com.codingempire.moodbeatbox.data.repository.MusicRepository
import com.codingempire.moodbeatbox.databinding.ActivityMusicPlayerBinding
import com.codingempire.moodbeatbox.utils.Constants

class MusicPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicPlayerBinding
    private var mediaPlayer: MediaPlayer? = null
    private var currentSongIndex = 0
    private lateinit var songs: List<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mood = intent.getStringExtra(Constants.EXTRA_SELECTED_MOOD) ?: "Happy"
        songs = MusicRepository().getSongsForMood(mood)

        if (songs.isEmpty()) {
            Toast.makeText(this, "No songs found for this mood.", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            playSong(currentSongIndex)
        }

        binding.btnPlayPause.setOnClickListener {
            togglePlayPause()
        }

        binding.btnNext.setOnClickListener {
            playNext()
        }

        binding.btnPrevious.setOnClickListener {
            playPrevious()
        }
    }

    private fun playSong(index: Int) {
        releaseMediaPlayer()

        val song = songs[index]
        binding.tvSongTitle.text = song.title

        mediaPlayer = MediaPlayer.create(this, song.resId).apply {
            start()
            setOnCompletionListener {
                playNext()
            }
        }

        binding.btnPlayPause.text = "Pause"
    }

    private fun togglePlayPause() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                binding.btnPlayPause.text = "Play"
            } else {
                it.start()
                binding.btnPlayPause.text = "Pause"
            }
        }
    }

    private fun playNext() {
        currentSongIndex = (currentSongIndex + 1) % songs.size
        playSong(currentSongIndex)
    }

    private fun playPrevious() {
        currentSongIndex = if (currentSongIndex - 1 < 0) songs.size - 1 else currentSongIndex - 1
        playSong(currentSongIndex)
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseMediaPlayer()
    }
}
