package metd.content;

import arc.func.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.world.Block;
import metd.content.metdItems.*;
import metd.content.metdLiquids.*;
import metd.content.metdBlocks.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static metd.content.metdItems.*;
import static metd.content.metdLiquids.*;
import static metd.content.metdBlocks.*;

public class metdTechTree {
    
public static void load(){
    nodeRoot("Metaldustry", Metaldustry, false, () -> {
        node(rawAluminium, () ->{
            node(rawIron, ()-> {
                node(rawTin);
        });
        });
        node(aluminium, () -> {
            node(iron, () -> {
                node(lithium, () -> {
                    node(nickel, () -> {
                        node(constantan);
                        node(silver, () -> {
                            node(tin, () -> {
                                node(bronze);
                            });
                        });
                    });
                });
                node(steel);
            });
        });
        node(bmg, () ->{
            node(bmgHE, () -> {
                node(bmgNuclear);
            });
        });
        node(heatwave,() -> {
            node(antiMaterielSniper);
        });
        node(ironWall, () ->{
            node(ironWallLarge);
            node(bronzeWall, () -> {
                node(bronzeWallLarge);
                node(steelWall, () -> {
                    node(steelWallLarge);
                });
            });
        });
        node(aluminiumConduit);
        node(tinDuct, () ->{
            node(tinDuctBridge);
        });
        node(lithiumBattery,() ->{
            node(lithiumBatteryLarge);
        });
        node(slagMixer, () -> {
            node(metalSeparator, () -> {
                node(ammoCrafter);
                node(alloyFurnance);
            });
        });
        node(metdItems.stone, () -> {
            node(stoneMelter, () -> {
                node(lavaHeater);
                node(heatGenerator);
            });
        });
        node(oreMelter, () -> {
            node(metalFormer);
            node(moltenAluminium);
            node(moltenIron);
            node(moltenTin);
        });
    });
}
}
