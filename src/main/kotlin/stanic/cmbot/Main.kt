package stanic.cmbot

import br.com.devsrsouza.jda.command.commands
import club.minnced.jda.reactor.ReactiveEventManager
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import stanic.cmbot.discord.commands.utils.registerHelpCommand

class Main {

    lateinit var manager: ReactiveEventManager

    companion object {
        lateinit var INSTANCE: Main

        @JvmStatic fun main(args: Array<String>) {
            INSTANCE = Main()

            INSTANCE.manager = ReactiveEventManager()

            val jda = JDABuilder.createDefault("TOKEN")
                .setActivity(Activity.playing("CM-Bot"))
                .setEventManager(INSTANCE.manager)
                .build()
            jda.awaitReady().runCatching {
                commands("!") {
                    registerHelpCommand()
                }
            }
        }
    }

}