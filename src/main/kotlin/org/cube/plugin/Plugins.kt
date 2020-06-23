package org.cube.plugin

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import java.io.File


object Plugins {

    private var directorys : MutableList<File> = emptyList<File>().toMutableList()
    private var jars : MutableList<File> = emptyList<File>().toMutableList()


    fun findDirectorys(path : String) {
        File("$path/").walkTopDown().forEach {
            if (it.isDirectory && it.toString() != "plugins") {
                directorys.add(it)
            }
        }
        findJars()
    }

    private fun findJars() {
        directorys.forEach { dir ->
            File(dir.absolutePath).walkTopDown().forEach {
                if(it.toString().contains(".jar")) {
                    jars.add(it)
                }
            }
        }
        loadJars()
    }

    private fun loadJars() {
        jars.forEach {
            val plugin: Plugin = Bukkit.getServer().pluginManager.loadPlugin(it)
            Bukkit.getServer().pluginManager.enablePlugin(plugin)
        }
    }



}