package org.cube.plugin.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.cube.api.commands.MinecraftCommand
import org.cube.api.player.message

@MinecraftCommand("polist","List Plugins and Versions","/podump",[])

class List : CommandExecutor {

    override fun onCommand(player: CommandSender, command: Command, label: String, args: Array<String>): Boolean {

        Bukkit.getServer().pluginManager.plugins.sortBy { it.name }

        Bukkit.getServer().pluginManager.plugins.forEach {
            var version = ""
            if(args.isNotEmpty() && args[0].contains("-v")) {
                version = "${ChatColor.GOLD} [Version ${it.description.version}]"
            }
            Bukkit.getConsoleSender().sendMessage("${ChatColor.GREEN} ${it.name} $version")
            if(player is Player) {
                player.message("${ChatColor.GREEN} ${it.name} $version")
            }
        }


        return true
    }
}