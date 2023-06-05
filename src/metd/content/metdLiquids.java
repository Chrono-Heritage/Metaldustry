package metd.content;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.content.*;

public class metdLiquids {
    public static Liquid
    /* Molten Metals */
    moltenAluminium, moltenIron, moltenTin,
    /* Others */
    lava;

    public static void load(){
        /*Molten Metals */
        moltenAluminium = new Liquid("molten-aluminium", Color.valueOf("BDC7CC")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("DEEAEF").a(0.5f);
        }};
        moltenIron = new Liquid("molten-iron", Color.valueOf("D8D8D8")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("E0E0E0").a(0.5f);
        }};
        moltenTin = new Liquid("molten-tin", Color.valueOf("CEE3E3")){{
            flammability = 4.0f;
            temperature = 4.0f;
            heatCapacity = 0f;
            viscosity = 0.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("DAEFEF").a(0.6f);
        }};
        /* Others */
        lava = new Liquid("lava", Color.valueOf("BC3F11")){{
            flammability = 5.0f;
            temperature = 5.0f;
            heatCapacity = 0f;
            viscosity = 0.9f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("ed760e").a(0.6f);
        }};
}
}