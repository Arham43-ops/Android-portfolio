package com.example.portfolio_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Animation Helper
        fun animateCard(view: android.view.View, delay: Long) {
            view.alpha = 0f
            view.translationY = 100f
            view.animate()
                .alpha(1f)
                .translationY(0f)
                .setStartDelay(delay)
                .setDuration(500)
                .start()
        }

        val cardAbout = findViewById<MaterialCardView>(R.id.cardAbout)
        val cardExperience = findViewById<MaterialCardView>(R.id.cardExperience)
        val cardSkills = findViewById<MaterialCardView>(R.id.cardSkills)
        val cardSocial = findViewById<MaterialCardView>(R.id.cardSocial)
        val cardContact = findViewById<MaterialCardView>(R.id.cardContact)
        val cardResume = findViewById<MaterialCardView>(R.id.cardResume)
        val cardVideos = findViewById<MaterialCardView>(R.id.cardVideos)

        animateCard(cardAbout, 100)
        animateCard(cardExperience, 200)
        animateCard(cardSkills, 300)
        animateCard(cardSocial, 400)
        animateCard(cardResume, 500)
        animateCard(cardVideos, 600)
        animateCard(cardContact, 700)

        // Setup Navigation
        cardAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        cardExperience.setOnClickListener {
            startActivity(Intent(this, ExperienceActivity::class.java))
        }

        cardSkills.setOnClickListener {
            startActivity(Intent(this, SkillsActivity::class.java))
        }

        cardSocial.setOnClickListener {
            startActivity(Intent(this, SocialHubActivity::class.java))
        }

        cardResume.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("EXTRA_URL", "file:///android_asset/index.html")
            startActivity(intent)
        }

        cardVideos.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("EXTRA_URL", "https://www.youtube.com/watch?v=Aq5WXmQQooo")
            startActivity(intent)
        }

        cardContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }
    }
}