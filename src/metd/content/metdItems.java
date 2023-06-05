package metd.content;

import arc.graphics.*;
import mindustry.type.*;

public class metdItems {

    public static Item
    /* Base Metals */
    aluminium, iron, lithium, nickel, silver, tin,
    /* Alloys */
    bronze, constantan, steel,
    /* Ammo */
    bmgHE, bmgNuclear, bmg,
    /* Others */
    stone,
    /* Ores */
    rawAluminium, rawIron, rawTin;
    public static void load() {
        /* Base Metals */
        aluminium  = new Item("aluminium", Color.valueOf("BDC7CC")){{
            charge = 0.5f;
            cost = 0.7f;
            hardness = 2;
        }};    
        iron  = new Item("iron", Color.valueOf("D8D8D8")){{
            charge = 1.0f;
            hardness = 2;
        }};       
        lithium  = new Item("lithium", Color.valueOf("FFFFFF")){{
            charge = 0.65f;
            cost = 0.85f;
            hardness = 2;
        }};    
        nickel  = new Item("nickel", Color.valueOf("C6C38B")){{
            charge = 0.1f;
            cost = 1.1f;
            hardness = 3;
        }};      
        silver  = new Item("silver", Color.valueOf("DBF0F3")){{
            charge = 0.1f;
            cost = 1.0f;
            hardness = 3;
        }};   
        tin  = new Item("tin", Color.valueOf("CEE3E3")){{
            charge = 0.1f;
            cost = 0.5f;
            hardness = 1;
        }};     
        /* Alloys */
        bronze  = new Item("bronze", Color.valueOf("FFC478")){{
            charge = 0.2f;
            cost = 1.1f;
        }};     
        constantan  = new Item("constantan", Color.valueOf("FAD37C")){{
            charge = 0.75f;
            cost = 1.2f;
        }};     
        steel  = new Item("steel", Color.valueOf("A6A6A6")){{
            charge = 0.5f;
            cost = 1.5f;
        }};  
        /* Ammo */
        bmg  = new Item(".50-bmg", Color.valueOf("3F3F3F")){{
            buildable = false;
        }};
        bmgHE  = new Item(".50-bmg-he", Color.valueOf("FF0F33")){{
            explosiveness = 1.0f;
            buildable = false;
        }};  
        bmgNuclear  = new Item(".50-bmg-nuclear", Color.valueOf("33BF31")){{
            explosiveness = 1.0f;
            flammability = 1.0f;
            radioactivity = 1.0f;
            buildable = false;
        }};  
        /* Others */
        stone  = new Item("stone", Color.valueOf("8C8C8C")){{
            cost = 0.1f;
            lowPriority = true;
            buildable = false;
        }};   
        /* Ores */ 
        rawAluminium = new Item("raw-aluminium", Color.valueOf("BDC7CC")){{
            hardness = 2;
            buildable = false;
        }};
        rawIron = new Item("raw-iron", Color.valueOf("D8D8D8")){{
            hardness = 2;
            buildable = false;
        }};
        rawTin = new Item("raw-tin", Color.valueOf("CEE3E3")){{
            hardness = 1;
            buildable = false;
        }};
    };
};