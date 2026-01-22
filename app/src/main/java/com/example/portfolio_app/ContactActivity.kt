package com.example.portfolio_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        findViewById<MaterialCardView>(R.id.cardForm).setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("EXTRA_URL", "https://docs.google.com/forms/d/e/1FAIpQLSccf0_v4QF9IWrryYuXzmcHWHCMFf4eEWRKL8UE5LU0MxZgoQ/viewform?usp=dialog")
            startActivity(intent)
        }

        findViewById<MaterialCardView>(R.id.cardEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:contact@example.com")
            }
            startActivity(intent)
        }

        findViewById<MaterialCardView>(R.id.cardPhone).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+1234567890")
            }
            startActivity(intent)
        }
    }
}
