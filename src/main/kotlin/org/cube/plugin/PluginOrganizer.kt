package org.cube.plugin

import org.bukkit.plugin.Plugin
import org.cube.api.CubePlugin

class PluginOrganizer : CubePlugin() {


    companion object {
        lateinit var plugin : Plugin
    }

    override fun start() {
        Plugins.findDirectorys(dataFolder.parentFile.toString())
    }


    override fun stop() {

    }
}