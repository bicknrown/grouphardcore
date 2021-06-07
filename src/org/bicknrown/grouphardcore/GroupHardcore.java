package org.bicknrown.grouphardcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.FileUtil;


import java.io.File;
import java.io.IOException;

public class GroupHardcore extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(),this);
        System.out.println("[GroupHardcore] Plugin loaded!");
    }
    @Override
    public void onDisable() {
        System.out.println("[GroupHardcore] Plugin unloaded!");
    }

}
