# Music-App 🎶  

A simple, fully offline Android music player — sorted by mood.  

## What is This  

Music-App is a local music player for Android devices: as soon as you run it, it scans the device for audio files, lets you tag or categorize songs by mood (e.g. Chill, Focus, Workout, Happy, Sad), and then allows playback **entirely offline**.  
No streaming, no server, no credentials, no privacy-infringing permissions — just music, the way you feel.

## Why  

- Sometimes you don’t want streaming.  
- Sometimes you want music that matches your mood — instantly.  
- Sometimes you’re offline or don’t want data usage.  
- This app gives you a mood-aware, lightning-fast, offline-first experience.

## Features  

- 💽 **Local file scanning** — automatically finds music files on your storage.  
- 🎭 **Mood-based playlists** — tag or categorize songs by mood, then pick a mood to play.  
- ▶️ **One-tap play** — select a mood → playlist loads → playback starts.  
- 🔀 **Shuffle and queue management** — mood-specific shuffle so you get a fresh mix each time.  
- 📱 **Android native (Kotlin)** — built with Jetpack / standard Android libs for smooth performance.  
- 🌙 **Works fully offline** — no network calls, no ads, no unwanted permissions.  

## Tech & Structure  

- Developed in **Kotlin** (see code base: 100% Kotlin). :contentReference[oaicite:1]{index=1}  
- Standard Android project structure (Gradle build scripts, `app/` module). :contentReference[oaicite:2]{index=2}  
- Use of Android media APIs (MediaPlayer or ExoPlayer — whichever you prefer to implement).  
- Simple architecture: scanning → categorizing → playlist / mood mapping → playback.  

## Getting Started  

Clone the repo and open in Android Studio:

```bash
git clone https://github.com/Rarenayab520/Music-App.git
cd Music-App
# Then open the project in Android Studio and build/run on device or emulator.
