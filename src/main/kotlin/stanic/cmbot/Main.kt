package stanic.cmbot

import br.com.devsrsouza.jda.command.commands
import club.minnced.jda.reactor.ReactiveEventManager
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import stanic.cmbot.database.Database
import stanic.cmbot.discord.commands.utils.registerHelpCommand
import stanic.cmbot.factory.GuildFactory

class Main {

    lateinit var manager: ReactiveEventManager

    companion object {
        lateinit var INSTANCE: Main

        @JvmStatic fun main(args: Array<String>) {
            INSTANCE = Main()
            Database().start()

            INSTANCE.manager = ReactiveEventManager()

            val jda = JDABuilder.createDefault(args[0])
                .setActivity(Activity.playing("CM-Bot"))
                .setEventManager(INSTANCE.manager)
                .build()
            jda.awaitReady().runCatching {
                commands("!") {
                    registerHelpCommand()
                }
            }

            GuildFactory().start()
        }
    }

}