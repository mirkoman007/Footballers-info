package mirkozaper.from.hr.footballersinfo.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mirkozaper.from.hr.footballersinfo.model.Player

class PlayersRepository {

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    fun loadPlayers(){

        val players= listOf(
                Player("Marko","Livaja",1.82f,"Left Winger",28),
                Player("Mario","Pašalić",1.86f,"Central Midfield",26),
                Player("Paulo","Dybala",1.77f,"Second Striker",27),
                Player("Robert","Lewandowski",1.85f,"Centre-Forward",33),
                Player("Ivan","Perišić",1.86f,"Left Midfield",32),
                Player("Ivica","Ivušić",1.95f,"Goalkeeper",26),
                Player("Mihael","Žaper",1.88f,"Defensive Midfield",23),
                Player("Kylian","Mbappé",1.78f,"Centre-Forward",22),
                Player("Ante","Rebić",1.85f,"Left Winger",27),
                Player("Kristijan","Lovrić",1.86f,"Left Winger",25))

        _players.setValue(players)
    }

}