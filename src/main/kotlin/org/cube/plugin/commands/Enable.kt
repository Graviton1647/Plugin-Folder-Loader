package org.cube.plugin.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.cube.api.commands.MinecraftCommand
import org.cube.api.player.message
import org.cube.plugin.PluginOrganizer.Companion.plugin
import java.io.File

@MinecraftCommand("poenable","Enables a Plugin","/poenable",[])

class Enable : CommandExecutor {

    override fun onCommand(player: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        val plugin = Bukkit.getServer().pluginManager.getPlugin(args[0])
        if(args[0].isNotEmpty() && args.size <= 1) {
            if(plugin == null) {
                Bukkit.getConsoleSender().sendMessage("${ChatColor.GREEN} Plugin ${args[0]} Could not be found")
                if(player is Player) {
                    player.message("${ChatColor.GREEN} Plugin ${args[0]} Could not be found")
                }
                return true
            } else {
                if (plugin.isEnabled) {
                    Bukkit.getConsoleSender().sendMessage("${ChatColor.RED} Plugin ${args[0]} Already Enabled")
                    if(player is Player) {
                        player.message("${ChatColor.RED} Plugin ${args[0]} Already Enabled")
                    }
                    return true
                } else {
                    Bukkit.getServer().pluginManager.enablePlugin(plugin)
                    Bukkit.getConsoleSender().sendMessage("${ChatColor.RED} Plugin ${args[0]} Plugin Enabled")
                    if(player is Player) {
                        player.message("${ChatColor.RED} Plugin ${args[0]} Plugin Enabled")
                    }
                }
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("${ChatColor.RED} Please Enter a plugin name")
            if(player is Player) {
                player.message("${ChatColor.RED} Please Enter a plugin name")
            }
            return true
        }
        return true
    }

}