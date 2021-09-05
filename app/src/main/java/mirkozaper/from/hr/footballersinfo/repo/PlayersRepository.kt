package mirkozaper.from.hr.footballersinfo.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mirkozaper.from.hr.footballersinfo.model.Player

class PlayersRepository {

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    fun loadPlayers(){

        var players= listOf(Player("Ivan","Perišić"),
                Player("Ante","Rebić"),
                Player("Marko","Livaja"),
                Player("Robert","Lewandowski"),
                Player("Kristijan","Lovrić"),
                Player("Ivica","Ivušić"),
                Player("Marko","Livaja"),
                Player("Kylian","Mbappé"))

        _players.setValue(players)
    }

}