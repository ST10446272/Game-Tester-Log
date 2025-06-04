package vcmsa.ci.gametester

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)

        val start = findViewById<Button>(R.id.btnStart)
        start.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        val exit = findViewById<Button>(R.id.btnExit)
        exit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}