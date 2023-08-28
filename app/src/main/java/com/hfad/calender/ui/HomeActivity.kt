package com.hfad.calender.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import com.hfad.calender.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.calenderBtn

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        calenderBtn.setOnClickListener {

            val intent =
                Intent(this@HomeActivity, CreateTaskActivity::class.java)
            startActivity(intent)
        }
    }

}