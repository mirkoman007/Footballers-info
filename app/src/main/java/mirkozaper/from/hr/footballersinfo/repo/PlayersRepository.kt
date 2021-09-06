package mirkozaper.from.hr.footballersinfo.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mirkozaper.from.hr.footballersinfo.model.Player

class PlayersRepository {

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    fun loadPlayers(){

        val players= listOf(
                Player("Marko","Livaja",1.82f),
                Player("Mario","Pašalić",1.86f),
                Player("Paulo","Dybala",1.77f),
                Player("Robert","Lewandowski",1.85f),
                Player("Ivan","Perišić",1.86f),
                Player("Ivica","Ivušić",1.95f),
                Player("Mihael","Žaper",1.88f),
                Player("Kylian","Mbappé",1.78f),
                Player("Ante","Rebić",1.85f),
                Player("Kristijan","Lovrić",1.86f))

        _players.setValue(players)
    }

}