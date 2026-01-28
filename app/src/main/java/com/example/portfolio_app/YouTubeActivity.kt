package com.example.portfolio_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class YouTubeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        val videoId = intent.getStringExtra("EXTRA_VIDEO_ID") ?: "dQw4w9WgXcQ" // Default fallback

        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }

            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
                super.onError(youTubePlayer, error)
                // If playback fails (e.g. embed restriction), open in YouTube app/browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$videoId"))
                try {
                    startActivity(intent)
                    finish() // Close this activity since we're moving to the app
                } catch (e: Exception) {
                    Toast.makeText(this@YouTubeActivity, "Error playing video: ${error.name}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
