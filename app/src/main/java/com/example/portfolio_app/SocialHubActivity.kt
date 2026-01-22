package com.example.portfolio_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class SocialHubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_hub)

        setupLink(R.id.cardGithub, "https://github.com/Arham43-ops")
        setupLink(R.id.cardLeetcode, "https://leetcode.com/u/arham43-ops/")
        setupLink(R.id.cardLinkedin, "https://www.linkedin.com/in/arham43-ops/")
        setupLink(R.id.cardPortfolio, "https://arham-portfolio-v2.netlify.app/")
        setupLink(R.id.cardWhatsApp, "https://wa.me/919512959909")
        setupLink(R.id.cardInstagram, "https://www.instagram.com/ofc.not_arham")
    }

    private fun setupLink(cardId: Int, url: String) {
        findViewById<MaterialCardView>(cardId).setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("EXTRA_URL", url)
            startActivity(intent)
        }
    }
}
