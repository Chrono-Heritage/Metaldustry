package metd.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.content.Fx;
import mindustry.content.Fx.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.*;
import metd.content.metdItems.*;
import metd.content.metdLiquids.*;
import metd.content.metdStatusEffects.*;
import metd.content.metdBlocks.*;
import metd.content.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.StatusEffects.*;
import static metd.content.metdItems.*;
import static metd.content.metdLiquids.*;
import static metd.content.metdStatusEffects.*;
import static mindustry.type.ItemStack.*;

public class metdUnitTypes {
    public static UnitType
    pistoler, twinPistoler, multiPistoler;

    public static void load(){
        pistoler = new UnitType("pistoler"){{
            constructor = UnitEntity::create;
            speed = 0.6f;
            hitSize = 9f;
            health = 250;
            weapons.add(new Weapon("chrono-metaldustry-pistol"){{
                reload = 30f;
                x = 4f;
                y = 2f;
                top = false;
                rotate = false;
                mirror = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 15){{
                    width = 7f;
                    height = 9f;
                    lifetime = 50f;
                }};
            }});
        }};
        twinPistoler = new UnitType("twin-pistoler"){{
            constructor = UnitEntity::create;
            speed = 0.5f;
            hitSize = 10f;
            health = 350;
            weapons.add(new Weapon("chrono-metaldustry-pistolBig"){{
                reload = 30f;
                x = 6f;
                y = 3f;
                top = false;
                rotate = false;
                mirror = true;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 15){{
                    width = 8f;
                    height = 10f;
                    lifetime = 50f;
                }};
            }});
        }};
        multiPistoler = new UnitType("multi-pistoler"){{
            constructor = UnitEntity::create;
            speed = 0.45f;
            hitSize = 13f;
            rotateSpeed = 3f;
            health = 900;
            armor = 9f;
            mechFrontSway = 0.55f;
            weapons.add(new Weapon("chrono-metaldustry-pistolBigger"){{
                reload = 25f;
                y = 1f;
                x = 9f;
                top = false;
                rotate = false;
                recoil = 4f;
                shake = 2f;
                ejectEffect = Fx.casing2;
                bullet = new ArtilleryBulletType(3f, 20){{
                    width = 9f;
                    height = 11f;
                    lifetime = 60f;
                }};
            }});
            weapons.add(new Weapon("chrono-metaldustry-pistolBig"){{
                reload = 30f;
                x = 4f;
                y = 2f;
                top = false;
                rotate = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3.25f, 15){{
                    width = 7f;
                    height = 9f;
                    lifetime = 50f;
                }};
            }});
        }};
    };
}
