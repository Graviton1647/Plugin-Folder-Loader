package org.cube.plugin.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cube.api.commands.MinecraftCommand
import org.cube.api.player.message
import org.cube.plugin.PluginOrganizer.Companion.plugin
import java.io.File

@MinecraftCommand("podump","Dump Plugin infomation","/podump",[])

class Dump : CommandExecutor {

    override fun onCommand(player: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        File(plugin.dataFolder, "dump.txt").printWriter().use { out ->
            Bukkit.getServer().pluginManager.plugins.forEach {
                out.println("${it.name} Version: ${it.description.version}")
            }
        }

        Bukkit.getConsoleSender().sendMessage("${ChatColor.GREEN} Plugin Infomation Dumped")
        if(player is Player) {
            player.message("${ChatColor.GREEN} Plugin Infomation Dumped")
        }

        return true
    }
}