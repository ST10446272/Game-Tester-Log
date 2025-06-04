package vcmsa.ci.gametester
/*
https://www.geeksforgeeks.org/radiobutton-in-kotlin/
https://www.geeksforgeeks.org/exposed-drop-down-menu-in-android/
https://www.geeksforgeeks.org/datepicker-in-kotlin/
 */
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class ViewActivity : AppCompatActivity() {

    private lateinit var date: ArrayList<String>
    private lateinit var minutes : ArrayList<String>
    private lateinit var genre : ArrayList<String>
    private lateinit var rating : ArrayList<String>
    private lateinit var content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)

        date = intent.getStringArrayListExtra("date")?: arrayListOf()
        minutes = intent.getStringArrayListExtra("minutes")?: arrayListOf()
        genre = intent.getStringArrayListExtra("genre")?: arrayListOf()
        rating = intent.getStringArrayListExtra("rating")?: arrayListOf()

        content = findViewById(R.id.tvContent)

        // Display entries
        if (date.isNotEmpty()) {
            val builder = StringBuilder()
            for (i in date.indices) {
                builder.append("Entry ${i + 1}:\n")
                builder.append("Date: ${date[i]}\n")
                builder.append("Minutes Played: ${minutes[i]}\n")
                builder.append("Genre: ${genre[i]}\n")
                builder.append("Rating: ${rating[i]}\n\n")
            }
            content.text = builder.toString()
        } else {
            content.text = "No data available. Please go back and add some entries."
        }


        val totalMinutes = findViewById<Button>(R.id.btnTotalMinutes)
        totalMinutes.setOnClickListener {
            handleTotalNumberOfSessions()
        }
        val highest = findViewById<Button>(R.id.btnHighest)
        highest.setOnClickListener {
            handleHighestRatedAndGenre()
        }
        val average = findViewById<Button>(R.id.btnAverage)
        average.setOnClickListener {
            handleAverageMinutesPerDay()
        }

        val back = findViewById<Button>(R.id.btnBack)
        back.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        val exit = findViewById<Button>(R.id.btnExit)
        exit.setOnClickListener {
           finishAffinity()
            exitProcess(0)
        }

    }
    private fun handleTotalNumberOfSessions(){
        val totalSessionsPlayed = date.size
        val totalMinutesPlayed = minutes.map { it.toIntOrNull() ?: 0 }.sum()
        content.text = "Total Sessions: $totalSessionsPlayed\nTotal Minutes Played: $totalMinutesPlayed"
    }
    private fun handleHighestRatedAndGenre(){
        if (rating.isEmpty()) {
            content.text = "No ratings available."
            return
        }
        // Convert rating strings to Ints
        val gameRatings = rating.map { it.toIntOrNull() ?: 0 }

        val highestRating = gameRatings.maxOrNull() ?: 0

        // Get all genres with the highest rating
        val genreRating = mutableListOf<String>()
        for (i in gameRatings.indices) {
            if (gameRatings[i] == highestRating) {
                genreRating.add("${genre[i]} on ${date[i]}")
            }
        }
        content.text = "Highest Rating: $highestRating\nGenres with highest rating:\n${genreRating.joinToString("\n")}"
    }
    private fun handleAverageMinutesPerDay(){
        if (date.isEmpty()) {
            content.text = "No data to calculate average."
            return
        }
        val totalMinutesPlayed = minutes.map { it.toIntOrNull() ?: 0 }.sum()
        val uniqueDates = date.toSet().size // Avoid counting the same date multiple times

        val average = if (uniqueDates > 0) totalMinutesPlayed / uniqueDates else 0

        content.text = "Average Minutes Per Day: $average"
    }
}