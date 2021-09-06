package mirkozaper.from.hr.footballersinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME:Long=3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val splashLogoAnimation=AnimationUtils.loadAnimation(this,R.anim.splash_logo_animation)

        val splashLogo:ImageView= findViewById(R.id.splashLogo)
        splashLogo.startAnimation(splashLogoAnimation)

        val homeIntent= Intent(this@SplashScreen,MainActivity::class.java)


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(homeIntent)
            finish()
        },SPLASH_TIME)
    }
}