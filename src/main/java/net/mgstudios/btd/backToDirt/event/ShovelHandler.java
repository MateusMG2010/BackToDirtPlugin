package net.mgstudios.btd.backToDirt.event;

import net.mgstudios.btd.backToDirt.BackToDirt;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShovelHandler implements Listener {
    private boolean canChangeBlock(PlayerInteractEvent e){
        return e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.DIRT_PATH && Tag.ITEMS_SHOVELS.isTagged(e.getMaterial()) && e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getPlayer().isSneaking();
    }
    @EventHandler
    public void onPlayerUsePath(PlayerInteractEvent e){
        if(e.hasItem() && e.getClickedBlock() != null){
            if(canChangeBlock(e)){
                e.getPlayer().swingMainHand();
                Bukkit.getScheduler().runTaskLater(BackToDirt.getPlugin(BackToDirt.class), () -> {
                    e.getClickedBlock().setType(Material.DIRT, false);
                    e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.BLOCK_ROOTED_DIRT_PLACE, 1.0f, 1.0f);
                }, 1L);
            }
        }
    }
}