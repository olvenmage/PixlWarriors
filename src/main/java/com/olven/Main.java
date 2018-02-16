package com.olven;

import com.olven.core.childs.Goblin;
import com.olven.core.entities.NPC.NPC;
import com.olven.core.entities.enemies.Enemy;
import com.olven.core.instance.Game;
import com.olven.core.encounters.Fight;
import com.olven.core.entities.attributes.Attributes;
import com.olven.core.entities.effects.debuffs.Crippled;
import com.olven.core.entities.effects.debuffs.Vulnerable;
import com.olven.core.entities.player.Player;
import com.olven.core.instance.stages.Stages;
import com.olven.core.inventory.InventorySlot;
import com.olven.core.items.ItemEntity;
import com.olven.core.quests.types.KillQuest;
import com.olven.core.sets.ItemSet;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Game.init(Stages.Debugging);

        Player player = Game.player;

        player.inventory.addItem(Game.item("TEST_BELT"));


        player.setBaseDex(0);

        player.addEffect(new Crippled(10));
        player.addEffect(new Vulnerable(1).setDuration(2));

        Enemy gobl = new Goblin(3, 2, null);

        player.questLog.add(new KillQuest("Test", "hoi", new NPC(), gobl, 3));


        Map<String, Object> collection = Game.storage.getCollection();
//        List<ItemEntity> loot = Game.table("GOBLIN_TABLE1").getDrop();

        ItemSet testSet = Game.itemSet("TEST_SET");

        player.takeDamage(20);

        Fight fight = new Fight(null, null);

        fight.start();

        fight.kill(gobl);
        fight.kill(gobl);
        fight.kill(gobl);



        Game.print(player.stats.getStat(Attributes.Dexterity).getCurrent());

        List<InventorySlot> slot0 = player.getInventroy();
    }
}
