package vcmsa.ci.gametester

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.util.*

class InputActivity : AppCompatActivity() {

    private var date = mutableListOf<String>()
    private var minutes = mutableListOf<String>()
    private var genre = mutableListOf<String>()
    private var rating = mutableListOf<String>()

    // Late Initialized variables
    lateinit var radio_group: RadioGroup
    lateinit var button: Button

    private val MAX_ENTRIES = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val spinner: Spinner = findViewById(R.id.spinner)
        val items = listOf("Sports", "Puzzle", "Racing", "Shooter", "Survival")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter

        radio_group = findViewById(R.id.radio_group)
        button = findViewById(R.id.button)

        val clear = findViewById<Button>(R.id.btnClear)
        clear.setOnClickListener {
            handleClearContent()
        }

        val next = findViewById<Button>(R.id.btnView)
        next.setOnClickListener {
            if (date.isNotEmpty()) {
                val intent = Intent(this, ViewActivity::class.java)
                intent.putStringArrayListExtra("date", ArrayList(date))
                intent.putStringArrayListExtra("minutes", ArrayList(minutes))
                intent.putStringArrayListExtra("genre", ArrayList(genre))
                intent.putStringArrayListExtra("rating", ArrayList(rating))
                startActivity(intent)
            } else {
                Snackbar.make(next, "List is empty. Add entries first.", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        button.setOnClickListener {
            if (date.size >= MAX_ENTRIES) {
                Toast.makeText(this, "You can only add up to $MAX_ENTRIES entries.", Toast.LENGTH_SHORT).show()
                //return@setOnClickListener
            }
            val selectedRadioId = radio_group.checkedRadioButtonId
            val selectedRating = if (selectedRadioId != -1) {
                val radioButton: RadioButton = findViewById(selectedRadioId)
                radioButton.text.toString()
            } else {
                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()

            }

            val datePicker: DatePicker = findViewById(R.id.datePicker)
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1
            val year = datePicker.year
            val selectedDate = "$day/$month/$year"

            val selectedGenre = spinner.selectedItem.toString()

            val minutesEt = findViewById<EditText>(R.id.etMinutes)
            val minutesPlayed = minutesEt.text.toString()
            if (minutesPlayed.isBlank()) {
                Toast.makeText(this, "Please enter minutes played", Toast.LENGTH_SHORT).show()
            }

            date.add(selectedDate)
            minutes.add(minutesPlayed)
            genre.add(selectedGenre)
            rating.add(selectedRating.toString())

            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()

        }
    }

    // This method is properly inside the class
    fun radio_button_click(view: View) {
        val selectedId = radio_group.checkedRadioButtonId
        if (selectedId != -1) {
            val radio: RadioButton = findViewById(selectedId)
            Toast.makeText(applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleClearContent() {
        // Clear stored lists
        date.clear()
        minutes.clear()
        genre.clear()
        rating.clear()

        // Clear EditText
        val minutesEt = findViewById<EditText>(R.id.etMinutes)
        minutesEt.text.clear()

        // Reset Spinner to first item
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.setSelection(0)

        // Clear RadioGroup selection
        radio_group.clearCheck()

        // Reset DatePicker to today
        val datePicker: DatePicker = findViewById(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.updateDate(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        )
        Toast.makeText(this, "Inputs cleared", Toast.LENGTH_SHORT).show()
    }
}
