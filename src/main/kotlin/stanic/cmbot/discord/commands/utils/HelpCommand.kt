package stanic.cmbot.discord.commands.utils

import br.com.devsrsouza.jda.command.*
import br.com.devsrsouza.jda.command.utils.on
import club.minnced.jda.reactor.on
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.future.await
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.withTimeoutOrNull
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent
import stanic.cmbot.Main
import stanic.cmbot.utils.await

fun CommandHolder.registerHelpCommand() = command("help") {
    val helpMessage = channel.sendMessage(
        EmbedBuilder()
            .setTitle("Help")
            .setDescription("Click in ✅")
            .build()
    ).await()
    helpMessage.addReaction("✅").await()

    setup {
        on<GuildMessageReactionAddEvent>().asFlow()
            .filter { it.messageIdLong == helpMessage.idLong }
            .filterNot { it.reactionEmote.name == "✅" }
            .onEach { it.reaction.removeReaction(it.user).submit().await() }
            .launchIn(GlobalScope)
    }

    onDispose {
        message.delete().queue()
        helpMessage.delete().queue()
    }

    val reaction = withTimeoutOrNull(10000) {
        Main.INSTANCE.manager.on<GuildMessageReactionAddEvent>()
            .filter { it.messageIdLong == helpMessage.idLong }
            .filter { !it.user.isBot }
            .filter { it.reactionEmote.name == "✅" }
            .awaitFirst()
    } ?: fail { println("fail") }
}