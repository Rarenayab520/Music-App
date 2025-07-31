package com.codingempire.moodbeatbox.data.repository

import com.codingempire.moodbeatbox.R
import com.codingempire.moodbeatbox.data.model.Song

class MusicRepository {
    fun getSongsForMood(mood: String): List<Song> {
        return when (mood) {
            "Happy" -> listOf(
                Song("STFU AP-Dhillon", R.raw.stfu_ap_dhillon),
                Song("Fakira Song", R.raw.fakira)
            )
            "Sad" -> listOf(
                Song("Mein Ishq Likhun Tujhe Ho Jaye..", R.raw.ishq),
                Song("Tumhin Dillagi Bhul Jani Pary Gi.. ", R.raw.dillagi)
            )
            "Energetic" -> listOf(
                Song("Workout Jam", R.raw.supreme),
                Song("Boost Up", R.raw.her)
            )
            "Relaxed" -> listOf(
                Song("JhOL..", R.raw.jhol),
                Song("Sahibaa...", R.raw.sahiba)
            )
            else -> emptyList()
        }
    }
}
