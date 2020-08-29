package stanic.cmbot.guild.config

import stanic.cmbot.guild.model.Guild
import java.io.File

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

}