package mirkozaper.from.hr.footballersinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mirkozaper.from.hr.footballersinfo.pages.PlayerDetailsActivity
import mirkozaper.from.hr.footballersinfo.model.Player
import mirkozaper.from.hr.footballersinfo.pages.NewsFragment
import mirkozaper.from.hr.footballersinfo.repo.PlayersRepository

class MainActivity : AppCompatActivity() {

    private val playersRepository=PlayersRepository()
    private lateinit var heightDisplaySettingManager: HeightDisplaySettingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightDisplaySettingManager=HeightDisplaySettingManager(this)

        val playersList:RecyclerView=findViewById(R.id.playersList)

        playersList.layoutManager=LinearLayoutManager(this)

        val playerAdapter=PlayerAdapter(){player->
            showPlayerDetails(player)
        }

        playersList.adapter=playerAdapter

        val playersObserver= Observer<List<Player>>{player->
            playerAdapter.submitList(player)

        }
        playersRepository.players.observe(this,playersObserver)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.newsFrame,NewsFragment())
            .commit()

        playersRepository.loadPlayers()
    }

    private fun showPlayerDetails(p:Player){
        val playerDetailsIntent=Intent(this,PlayerDetailsActivity::class.java)
        playerDetailsIntent.putExtra("key_firstName",p.firstName)
        playerDetailsIntent.putExtra("key_lastName",p.lastName)
        playerDetailsIntent.putExtra("key_height",p.height.toString())
        startActivity(playerDetailsIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflaer: MenuInflater =menuInflater
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