package stanic.cmbot.guild.config

import org.json.JSONObject
import stanic.cmbot.guild.model.Guild
import java.io.File
import java.io.InputStream

class GuildConfig {

    fun generateFile(guild: Guild): File {
        val folder = File("config")
        if (!folder.exists()) folder.mkdirs()

        val file = File("config", "${guild.id}-config.json")
        File("config", "defaultconfig.json").copyTo(file)

        file.createNewFile()

        guild.fileLocation = "${guild.id}-config.json"
        return file
    }

    fun readConfigFile(inputStream: InputStream): JSONObject {
        val json: String = inputStream.bufferedReader().use { it.readText() }
        return JSONObject(json)
    }

}