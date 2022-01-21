package bedsleep.diamon.oneplayersleep.Diamon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class onePlayerSleep extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println(" Sleep to be Healthy 1 | Plugin Enabled");
        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        double playerHealth = player.getHealth();
        double playerSubtractedHealth = 20.0 - playerHealth;

        int playerFoodLevel = player.getFoodLevel();
        int playerSubtractedFoodLevel = 20 - playerFoodLevel;

        if (player.getHealth() < 20) {
            player.setHealth(playerHealth + playerSubtractedHealth);
            player.sendMessage("you have been" + ChatColor.RED + " Healed " + ChatColor.WHITE + "because you slept.");
        } else if (player.getHealth() == 20) {
            if (player.getFoodLevel() < 20) {
                player.setFoodLevel(playerFoodLevel + playerSubtractedFoodLevel);
                player.sendMessage("you have been" + ChatColor.DARK_RED + " Feed " + ChatColor.WHITE + "since you are already Healed");

            }
        }
    }


}
