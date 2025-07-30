package com.codingempire.moodbeatbox.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingempire.moodbeatbox.data.model.Song
import com.codingempire.moodbeatbox.data.repository.MusicRepository

class MusicViewModel : ViewModel() {

    private val repository = MusicRepository()

    private val _selectedMood = MutableLiveData<String>()
    val selectedMood: LiveData<String> get() = _selectedMood

    private val _songList = MutableLiveData<List<Song>>()
    val songList: LiveData<List<Song>> get() = _songList

    private val _currentSongIndex = MutableLiveData<Int>()
    val currentSongIndex: LiveData<Int> get() = _currentSongIndex

    private val _isPlaying = MutableLiveData<Boolean>(false)
    val isPlaying: LiveData<Boolean> get() = _isPlaying

    private var mediaPlayer: MediaPlayer? = null

    fun selectMood(mood: String, context: Context) {
        _selectedMood.value = mood
        val songs = repository.getSongsForMood(mood)
        _songList.value = songs
        _currentSongIndex.value = 0
        playSong(context)
    }

    fun playSong(context: Context) {
        stopPlayer()

        val index = _currentSongIndex.value ?: 0
        val song = _songList.value?.getOrNull(index) ?: return

        mediaPlayer = MediaPlayer.create(context, song.resId).apply {
            setOnCompletionListener {
                playNext(context)
            }
            start()
            _isPlaying.value = true
        }
    }

    fun playPauseToggle() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                _isPlaying.value = false
            } else {
                it.start()
                _isPlaying.value = true
            }
        }
    }

    fun playNext(context: Context) {
        val current = _currentSongIndex.value ?: return
        val songs = _songList.value ?: return
        if (current + 1 < songs.size) {
            _currentSongIndex.value = current + 1
            playSong(context)
        }
    }

    fun stopPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
        _isPlaying.value = false
    }

    override fun onCleared() {
        super.onCleared()
        stopPlayer()
    }
}
