package com.codingempire.moodbeatbox.data.repository

import com.codingempire.moodbeatbox.R
import com.codingempire.moodbeatbox.data.model.Song

class MusicRepository {
    fun getSongsForMood(mood: String): List<Song> {
        return when (mood) {
            "Happy" -> listOf(
                Song("Happy Vibes", R.raw.happy_vibes),
                Song("Sunshine Beat", R.raw.sunshine_beats)
            )
            "Sad" -> listOf(
                Song("Sad Piano", R.raw.sad_piano),
                Song("Rainy Mood", R.raw.sad_piano)
            )
            "Energetic" -> listOf(
                Song("Workout Jam", R.raw.happy_vibes),
                Song("Boost Up", R.raw.sunshine_beats)
            )
            "Calm" -> listOf(
                Song("Calm Waves", R.raw.sad_piano),
                Song("Zen Garden", R.raw.happy_vibes)
            )
            else -> emptyList()
        }
    }
}
