package mirkozaper.from.hr.footballersinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mirkozaper.from.hr.footballersinfo.model.Player
import mirkozaper.from.hr.footballersinfo.repo.PlayersRepository

class MainActivity : AppCompatActivity() {

    private val playersRepository=PlayersRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playersList:RecyclerView=findViewById(R.id.playersList)

        playersList.layoutManager=LinearLayoutManager(this)

        val playerAdapter=PlayerAdapter(){

        }
        playersList.adapter=playerAdapter

        val playersObserver= Observer<List<Player>>{player->
            playerAdapter.submitList(player)

        }
        playersRepository.players.observe(this,playersObserver)

        playersRepository.loadPlayers()
    }
}