package org.bicknrown.grouphardcore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.FileWriter;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        String deathMessage = event.getDeathMessage();
        Bukkit.broadcastMessage(event.getEntity().getDisplayName() + " Has Died!");
        Bukkit.broadcastMessage("Server Resetting!");

        for(Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("GroupHardcore"), new Runnable() {
                @Override
                public void run() {
                    player.kickPlayer(deathMessage + ", Server Resetting!");
                }
            });
        }

        File flag = new File("flag");
        File deathLog = new File("deathlog.txt");

        try {

            flag.createNewFile();
            deathLog.createNewFile();
            FileWriter writer = new FileWriter("deathlog.txt",true);
            writer.write(deathMessage + "\n");
            writer.close();
            System.out.println("Flag Created");

        } catch(Exception e) {

            e.printStackTrace();

        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"restart");

    }

}
