package stanic.cmbot.factory

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import stanic.cmbot.database.loadAll
import stanic.cmbot.guild.config.GuildConfig
import stanic.cmbot.guild.model.Guild
import java.io.InputStream

class GuildFactory {

    companion object {
        lateinit var INSTANCE: GuildFactory
    }

    fun start() {
        INSTANCE = this

        guilds = loadAll()
        GlobalScope.launch {
            delay(3000)
            GuildConfig().generateFile(guilds.values.first())
        }
    }

    private fun readJson(inputStream: InputStream): JSONObject {
        val json: String = inputStream.bufferedReader().use { it.readText() }
        return JSONObject(json)
    }

    lateinit var guilds: HashMap<String, Guild>

}