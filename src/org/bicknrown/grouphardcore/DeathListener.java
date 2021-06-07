package org.bicknrown.grouphardcore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        System.out.println("[GroupHardcore] A Player Died!");
        Bukkit.broadcastMessage(event.getEntity() + " Has Died!");
        Bukkit.broadcastMessage("Server Resetting!");

        for(Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("GroupHardcore"), new Runnable() {
                @Override
                public void run() {
                    player.kickPlayer("Server Resetting!");
                }
            });
        }

        File flag = new File("flag");

        try {

            flag.createNewFile();
            System.out.println("Flag Created");

        } catch(Exception e) {

            e.printStackTrace();

        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"restart");

    }

}
