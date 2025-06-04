package vcmsa.ci.gametester

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import java.util.Calendar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {

    // Late Initialized variables
    lateinit var radio_group: RadioGroup
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)

        val datePicker: DatePicker = findViewById(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val msg = "You Selected: $day/${month+1}/$year"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        val spinner: Spinner = findViewById(R.id.spinner)
        val items = listOf("Sports","Puzzle","Racing","Shooter","Survival")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter

        radio_group=findViewById<RadioGroup>(R.id.radio_group)
        button=findViewById<Button>(R.id.button)

        // Get radio group selected item
        // using on checked change listener
        radio_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(applicationContext," On checked change :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            })

        // Get radio group selected status
        // and text using button click event
        button.setOnClickListener{

            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId

            if (id!=-1){

                // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio:RadioButton = findViewById(id)
                Toast.makeText(applicationContext,"On button click :" +
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            }else{

                // If no radio button checked in this radio group
                Toast.makeText(applicationContext,"On button click :" +
                        " nothing selected",
                    Toast.LENGTH_SHORT).show()
            }
            // val add = findViewById<Button>(R.id.button)
            val clear = findViewById<Button>(R.id.btnClear)
            clear.setOnClickListener {
                handleClearContent()
            }
            val next = findViewById<Button>(R.id.btnView)
            next.setOnClickListener {
                val intent = Intent(this, ViewActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // Get the selected radio button text
    // using radio button on click listener
    fun radio_button_click(view: View)
    {
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }
    private fun handleClearContent(){}
}