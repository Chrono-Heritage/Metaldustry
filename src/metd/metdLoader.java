package metd;

import metd.content.metdItems;
import metd.content.metdLiquids;
import metd.content.metdUnitTypes;
import metd.content.metdBlocks;
import metd.content.metdTechTree;
import mindustry.mod.Mod;
import mindustry.content.Blocks;


public class metdLoader extends Mod{
    public metdLoader(){
    }

    @Override
    public void loadContent(){
        metdItems.load();
        metdLiquids.load();
        metdUnitTypes.load();
        metdBlocks.load();
        metdTechTree.load();
        (Blocks.stone).itemDrop = metdItems.stone;
        (Blocks.stone).playerUnmineable = true;
        (Blocks.craters).itemDrop = metdItems.stone;
        (Blocks.craters).playerUnmineable = true;
        (Blocks.charr).itemDrop = metdItems.stone;
        (Blocks.charr).playerUnmineable = true;
        (Blocks.basalt).itemDrop = metdItems.stone;
        (Blocks.basalt).playerUnmineable = true;
    };
}