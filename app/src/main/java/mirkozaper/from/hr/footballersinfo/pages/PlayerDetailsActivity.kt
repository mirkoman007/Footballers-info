package mirkozaper.from.hr.footballersinfo.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import mirkozaper.from.hr.footballersinfo.HeightDisplaySetting
import mirkozaper.from.hr.footballersinfo.HeightDisplaySettingManager
import mirkozaper.from.hr.footballersinfo.R
import mirkozaper.from.hr.footballersinfo.utils.getHeightFormat

class PlayerDetailsActivity : AppCompatActivity() {

    private lateinit var heightDisplaySettingManager: HeightDisplaySettingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_details)

        heightDisplaySettingManager=HeightDisplaySettingManager(this)

        setTitle(getString(R.string.player_details))

        val firstName=findViewById<TextView>(R.id.firstName)
        val lastName=findViewById<TextView>(R.id.lastName)
        val height=findViewById<TextView>(R.id.height)
        val position=findViewById<TextView>(R.id.position)
        val age=findViewById<TextView>(R.id.age)


        firstName.text=intent.getStringExtra("key_firstName")
        lastName.text=intent.getStringExtra("key_lastName")
        height.text=getHeightFormat(intent.getStringExtra("key_height")!!.toFloat(),heightDisplaySettingManager.getTempDisplaySettings())
        position.text=intent.getStringExtra("key_position")
        age.text=intent.getStringExtra("key_age")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflaer:MenuInflater=menuInflater
        inflaer.inflate(R.menu.settings_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.heightDisplaySetting ->{
                showHeightDisplaySettingDialog()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun showHeightDisplaySettingDialog(){
        val dialogBuilder=AlertDialog.Builder(this)
                .setTitle("Height unit")
                .setMessage("Please select height unit:")
                .setNeutralButton("meter"){ _, _ ->
                    heightDisplaySettingManager.updateSetting(HeightDisplaySetting.Meter)
                }
                .setPositiveButton("feet"){ _, _ ->
                    heightDisplaySettingManager.updateSetting(HeightDisplaySetting.Feet)
                }
                .setOnDismissListener{
                    Toast.makeText(this,"The change will be visible after restarting page",Toast.LENGTH_SHORT).show()
                }

        dialogBuilder.show()
    }
}