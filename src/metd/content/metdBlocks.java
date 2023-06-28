package metd.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import metd.content.metdItems.*;
import metd.content.metdLiquids.*;
import metd.content.metdStatusEffects.*;
import metd.content.metdBlocks.*;
import metd.content.metdUnitTypes.*;
import metd.content.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.StatusEffect.*;
import mindustry.content.StatusEffects.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.world.Block;
import multicraft.*;


import static mindustry.Vars.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static mindustry.content.StatusEffects.*;
import static metd.content.metdItems.*;
import static metd.content.metdLiquids.*;
import static metd.content.metdStatusEffects.*;
import static metd.content.metdUnitTypes.*;
import static mindustry.type.ItemStack.*;

public class metdBlocks {

    public static Block 
    /* Crafting */
    alloyFurnance, ammoCrafter, lavaHeater, metalFormer, metalSeparator, oreMelter, slagMixer, stoneMelter,
    /* Defence */
    bronzeWall, bronzeWallLarge, ironWall, ironWallLarge, steelWall, steelWallLarge,
    /* Distribution */
    aluminiumConduit, tinDuct, tinDuctBridge,
    /* Environment */
    oreIron, oreAluminium, oreTin,
    /* Misc */
    extendTank, extendStorage, Metaldustry,
    /* Power */
    heatGenerator, lithiumBattery, lithiumBatteryLarge,
    /* Production */
    /* Turret */
    antiMaterielSniper, machineGun, heatwave,
    /* Units */
    metalUnitFactory, metalT2Reconstructor, metalT3Reconstructor;
    public static void load() {
        alloyFurnance = new MultiCrafter("alloy-furnace"){{
            requirements(Category.crafting, with(copper, 75, aluminium, 50, tin, 50, graphite,35, silicon,35));
            researchCost = with(copper, 750, aluminium, 500, tin, 500, graphite,200, silicon,200);
            itemCapacity = 60;
            health = 650;
            size = 3;
            buildCostMultiplier = 1.25f;
            hasPower = true;
            hasItems = true;
            drawer = new DrawMulti(new DrawDefault(),new DrawFlame());
            consumePower(1.15f);

            resolvedRecipes = Seq.with(
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(iron,2, coal,3)),
                        Seq.with()
                    ),

                    new IOEntry(
                        Seq.with(ItemStack.with(steel, 2)),
                        Seq.with()
                    ),
                    60f
                ),
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(copper, 3, tin, 1)),
                        Seq.with()
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(bronze, 4)),
                        Seq.with()
                    ),
                    90f
                ),
                new Recipe(
                    new IOEntry(
                        Seq.with(ItemStack.with(copper,1 , nickel,1)),
                        Seq.with()
                    ),
                    new IOEntry(
                        Seq.with(ItemStack.with(constantan, 1)),
                        Seq.with()
                    ),
                    60f
                )
            );
        }};
    ammoCrafter = new MultiCrafter("ammo-crafter"){{
        requirements(Category.crafting, with(copper, 75, aluminium, 50, tin, 50, constantan,35, silicon,35));
        researchCost = with(copper,750, aluminium,500, tin,500, constantan,200, silicon,200);
        itemCapacity = 60;
        health = 950;
        size = 3;
        buildCostMultiplier = 1.25f;
        hasPower = true;
        hasItems = true;
        drawer = new DrawMulti(new DrawDefault(),new DrawFlame());
        consumePower(2.5f);

        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, nickel,12, steel,8)),
                    Seq.with()
                ),

                new IOEntry(
                    Seq.with(ItemStack.with(bmg, 8)),
                    Seq.with()
                ),
                180f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, blastCompound,12, nickel,12, steel,8)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(bmgHE, 8)),
                    Seq.with()
                ),
                240f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(copper,30, titanium,20, nickel,12, steel,8, blastCompound,8, thorium,8)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(bmgNuclear, 8)),
                    Seq.with()
                ),
                240f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(lead,20, steel,12, iron,12, bronze,10)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(machGunAmmo, 5)),
                    Seq.with()
                ),
                300f
            )
        );
    }};
    lavaHeater = new HeatProducer("lava-heater"){{
        requirements(Category.crafting, with(copper,150, lead,90, aluminium,65, tin,45, iron,45));
        researchCost = with(copper,1500, lead,850, aluminium,750, tin,550, iron,550);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        consumeLiquid(lava, 4f / 60f);
        consumePower(1.0f);
        rotateDraw = false;
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(), new DrawDefault());
        ambientSound = Sounds.extractLoop;
        ambientSoundVolume = 0.08f;
        regionRotated1 = 2;
        craftTime = 60f * 2f;
        heatOutput = 12f;
    }};
    metalFormer = new MultiCrafter("metal-former"){{
        requirements(Category.crafting, with(copper, 85, titanium, 35, graphite,20, silicon,20));
        researchCost = with(copper,850, silicon,550, titanium,450, graphite,200, silicon,200);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 1.75f;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        drawer = new DrawMulti(
            new DrawRegion("-bottom"),
            new DrawPistons(){{
                sinMag = 1f;
            }},
            new DrawDefault(),
            new DrawLiquidRegion(),
            new DrawRegion("-top")
            );
        consumePower(1.5f);
        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenAluminium, 0.1f))
                ),

                new IOEntry(
                    Seq.with(ItemStack.with(aluminium, 2)),
                    Seq.with()
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenIron, 0.1f))
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(iron, 2)),
                    Seq.with()
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenTin, 0.1f))
                ),
                new IOEntry(
                    Seq.with(ItemStack.with(tin, 2)),
                    Seq.with()
                ),
                90f
            )
        );
    }};
    metalSeparator = new Separator("metal-separator") {{
        requirements(Category.crafting, with(copper,350, silicon,125, graphite,125, metaglass,75));
        researchCost = with(copper,750, aluminium,500, tin,500, constantan,200, silicon,200);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 0.55f;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 15;
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 5, true), new DrawDefault());
        results = with(
            aluminium,2,
            iron,2,
            nickel,1,
            silver,1,
            tin,2,
            lithium,1
        );
        consumePower(2.5f);
        consumeLiquid(slag, 0.05f);
    }};
    slagMixer = new GenericCrafter("slag-mixer") {{
        requirements(Category.crafting, with(copper,200, lead,125, silicon,75, graphite,75, metaglass,45));
        researchCost= with(copper,3000, lead,2500, silicon,1500, graphite,1500, metaglass,650);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 60;
        buildCostMultiplier = 0.5f;
        outputLiquid = new LiquidStack(slag, 0.1f);
        drawer = new DrawMulti(new DrawRegion("-bottom"),  new DrawRegion("-spinner", 5, true), new DrawDefault());

        consumePower(1.5f);
        consumeItems(with(copper,2, lead,2));
    }};
    stoneMelter = new GenericCrafter("stone-melter") {{
        requirements(Category.crafting, with(copper,110, graphite,75, iron,55, metaglass,45));
        researchCost= with(copper,1250, graphite,850, iron,650, metaglass,550);
        itemCapacity = 60;
        liquidCapacity = 120;
        buildCostMultiplier = 1.35f;
        health = 750;
        size = 3;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        craftTime = 120;
        buildCostMultiplier = 0.5f;
        outputLiquid = new LiquidStack(lava, 0.15f);
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(lava), new DrawDefault(), new DrawFlame());

        consumePower(1.5f);
        consumeItems(with(stone,8));
    }};
    oreMelter = new MultiCrafter("ore-melter"){{
        requirements(Category.crafting, with(copper, 55, lead, 40, silicon, 35, metaglass,25));
        researchCost = with(copper,750, lead,500, silicon,400, metaglass,200);
        itemCapacity = 60;
        liquidCapacity = 120;
        health = 450;
        size = 2;
        hasPower = true;
        hasItems = true;
        hasLiquids = true;
        drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(), new DrawDefault(), new DrawRegion("-top"), new DrawFlame());
        consumePower(1.5f);
        resolvedRecipes = Seq.with(
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawAluminium, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenAluminium, 0.1f))
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawIron, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenIron, 0.1f))
                ),
                90f
            ),
            new Recipe(
                new IOEntry(
                    Seq.with(ItemStack.with(rawTin, 2)),
                    Seq.with()
                ),
                new IOEntry(
                    Seq.with(),
                    Seq.with(LiquidStack.with(moltenTin, 0.1f))
                ),
                90f
            )
        );
    }};
    /* Defence */
    bronzeWall = new Wall("bronze-wall"){{
        requirements(Category.defense, with(bronze, 10));
        health = 650;
        researchCostMultiplier = 20f;
    }};
    bronzeWallLarge = new Wall("bronze-wall-large"){{
        requirements(Category.defense, with(bronze, 40));
        health = 2925;
        size = 2;
        researchCostMultiplier = 20f;
    }};
    ironWall = new Wall("iron-wall"){{
        requirements(Category.defense, with(iron, 10));
        health = 500;
        researchCostMultiplier = 20f;
    }};
    ironWallLarge = new Wall("iron-wall-large"){{
        requirements(Category.defense, with(iron, 40));
        health = 2250;
        size = 2;
        researchCostMultiplier = 20f;
    }};
    steelWall = new Wall("steel-wall"){{
        requirements(Category.defense, with(steel, 10));
        health = 750;
        researchCostMultiplier = 20f;
    }};
    steelWallLarge = new Wall("steel-wall-large"){{
        requirements(Category.defense, with(steel, 40));
        health = 3375;
        size = 2;
        researchCostMultiplier = 20f;
    }};
    /* Distribution */
    aluminiumConduit = new Conduit("aluminium-conduit"){{
        requirements(Category.liquid, with(aluminium,1, titanium,1, metaglass,1));
        researchCost = with(tin,200, metaglass,200, aluminium,200);
        health = 120;
        liquidCapacity = 30f;
        liquidPressure = 1.5f;
    }};
    tinDuct = new Duct("tin-duct"){{
        requirements(Category.distribution, with(copper,1, metaglass,1, tin,1));
        researchCost = with(copper,200, metaglass,200, tin,200);
        health = 120;
        speed = 3.5f;
        itemCapacity = 5;
    }};
    tinDuctBridge = new DuctBridge("tin-duct-bridge"){{
        requirements(Category.distribution, with(copper,20, tin,20, constantan,10, aluminium,10));
        researchCost = with(copper,200, metaglass,200, tin,200);
        health = 160;
        speed = 3.5f;
        range = 20;
    }};
    /* Environment */
    oreAluminium = new OreBlock("ore-aluminium"){{
        oreDefault = true;
        oreThreshold = 0.864f;
        oreScale = 24.904762f;
        itemDrop = rawAluminium;
        localizedName = itemDrop.localizedName;
    }};
    oreIron = new OreBlock("ore-iron"){{
        oreDefault = true;
        oreThreshold = 0.864f;
        oreScale = 24.904762f;
        itemDrop = rawIron;
        localizedName = itemDrop.localizedName;
    }};
    oreTin = new OreBlock("ore-tin"){{
        oreDefault = true;
        oreThreshold = 0.864f;
        oreScale = 24.904762f;
        itemDrop = rawTin;
        localizedName = itemDrop.localizedName;
    }};
    /* Misc */
    extendTank = new LiquidRouter("extend-tank"){{
        requirements(Category.liquid, with(copper, 200, tin,120, steel,80, aluminium,40, metaglass, 30));
        researchCost = with(copper, 2000, tin,1250, steel,850, aluminium,650, metaglass, 450);
        health = 1250;
        liquidCapacity = 5600f;
        size = 5;
        solid = true;
        buildCostMultiplier = 0.65f;
    }};
    extendStorage = new StorageBlock("extend-storage"){{
        requirements(Category.effect, with(copper,200, tin,150, lead,150, iron,125, nickel,125));
        researchCost = with(copper,2000, tin,950, lead,950, iron,650, nickel,650);
        health = 1250;
        size = 5;
        itemCapacity = 4000;
        buildCostMultiplier = 0.65f;
    }};
    Metaldustry = new Wall("Metaldustry"){{
        requirements(Category.defense, with());
        health = 10;
        placeablePlayer = false;
    }};
    /* Power */
    heatGenerator = new HeaterGenerator("heat-generator"){{
        requirements(Category.power, with(copper,75, tin,55, aluminium,25, lithium,20));
        researchCost = with(copper,1500, tin,950, aluminium,450, lithium,450);
        liquidCapacity = 120;
        buildCostMultiplier = 1.45f;
        health = 750;
        size = 3;
        hasPower = true;
        hasLiquids = true;
        powerProduction = 2.5f;
        heatOutput = 4f;
        itemDuration = 1080f;
        ambientSoundVolume = 0.1f;

        consume(new ConsumeLiquidFlammable(0.1f));
        drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());
    }};
    lithiumBattery = new Battery("lithium-battery"){{
        requirements(Category.power, with(copper,150, lead,75, aluminium,55, tin,55, lithium,35));
        researchCost = with(copper,3000, lead, 1250, aluminium,1500, tin,1500, lithium,750);
        health = 625;
        size = 2;
        consumePowerBuffered(17250f);
    }};
    lithiumBatteryLarge = new Battery("lithium-battery-large"){{
        requirements(Category.power, with(copper,150, lead,100, graphite,75, aluminium,65, tin,65, lithium,50));
        researchCost = with(copper,3000, lead,2500, graphite,2000, aluminium,1500, tin,1500, lithium,750);
        health = 2500;
        size = 4;
        buildCostMultiplier = 0.75f;
        consumePowerBuffered(87500f);
    }};
    /* Production */
    /* Turrets */ 
    antiMaterielSniper = new ItemTurret("anti-materiel-sniper"){{
        requirements(Category.turret, with(copper,175, lead,150, aluminium,125, tin,125, steel,75, constantan,75));
        researchCost = with(copper,2750, lead,2500, aluminium,1750, tin,1750, steel,1250, constantan,1250);
        health = 1250;
        size = 4;
        liquidCapacity = 120;
        buildCostMultiplier = 0.75f;
        reload = 300f;
        maxAmmo = 10;
        range = 600;
        rotateSpeed = 10f;
        recoil = 5f;
        shootSound = Sounds.shootSmite;
        shootCone = 30f;
        shoot = new ShootSpread(2,0);
        coolant = consumeCoolant(0.5f);
        coolantMultiplier = 0.4f;
        ammo(
            bmg,  new PointLaserBulletType(){{
                speed = 100;
                scaleLife = true;
                smokeEffect = Fx.shootBigSmoke;
                buildingDamageMultiplier = 0.3f;
                damage = 2750;
                pierceArmor = true;
                ammoMultiplier = 1.0f;
            }},
            bmgHE,  new PointLaserBulletType(){{
                speed = 100;
                scaleLife = true;
                smokeEffect = Fx.shootBigSmoke;
                hitEffect = Fx.explosion;
                status = StatusEffects.burning;
                statusDuration = 600;
                buildingDamageMultiplier = 0.3f;
                damage = 2000;
                splashDamage = 2000;
                splashDamageRadius = 40;
                pierceArmor = true;
                ammoMultiplier = 1.0f;
            }},
            bmgNuclear,  new PointLaserBulletType(){{
                speed = 100;
                scaleLife = true;
                smokeEffect = Fx.shootBigSmoke;
                hitEffect = Fx.blastExplosion;
                buildingDamageMultiplier = 0.3f;
                status = radiation;
                statusDuration = 600;
                damage = 2000;
                splashDamage = 1875;
                splashDamageRadius = 56;
                pierceArmor = true;
                ammoMultiplier = 1.0f;
            }}
        );
    }};
    machineGun = new ItemTurret("machine-gun"){{
        requirements(Category.turret, with(copper,105, lead,75, aluminium,55, tin,45, steel,35, constantan,35));
        researchCost = with(copper,1550, lead,1250, aluminium,750, tin,550, steel,450, constantan,450);
        health = 850;
        size = 3;
        liquidCapacity = 120;
        buildCostMultiplier = 0.75f;
        reload = 1f;
        maxAmmo = 200;
        range = 150;
        rotateSpeed = 20f;
        recoil = 3f;
        shootSound = Sounds.shootAlt;
        shootCone = 30f;
        shoot = new ShootSpread(1,0);
        minWarmup = 0.8f;
        coolant = consumeCoolant(0.5f);
        coolantMultiplier = 0.15f;            
        drawer = new DrawTurret(){{
            for(int i = 3; i > 0; i--){
                parts.add(new RegionPart("-barrel-" + i){{
                    progress = PartProgress.recoil;
                    under = true;
                    moveY = -2f;
                }});
            }
        }};
        ammo(
            steel, new BasicBulletType(20f,5){{
                width = 3f;
                height = 11f;
                lifetime = 10f;
                ammoMultiplier = 5;
            }},
            machGunAmmo, new BasicBulletType(20f,10){{
                width = 3f;
                height = 11f;
                lifetime = 10f;
                ammoMultiplier = 3;
            }}
        );
    }};
    heatwave = new LiquidTurret("heatwave"){{
        requirements(Category.turret, with(copper,95, aluminium,55, tin,55, steel,35));
        researchCost = with(copper,1050, aluminium,650, tin,550, steel,450);
        liquidCapacity = 120f;
        buildCostMultiplier = 1.35f;
        size = 3;
        recoil = 0f;
        reload = 2f;
        inaccuracy = 5f;
        shootCone = 70f;
        shootEffect = Fx.shootLiquid;
        range = 128f;
        ammo(
            slag, new LiquidBulletType(Liquids.slag){{
                damage = 10;
                speed = 4f;
                knockback = 1.3f;
                puddleSize = 8f;
                orbSize = 4f;
                drag = 0.001f;
                statusDuration = 60f * 4f;
            }},
            lava, new LiquidBulletType(metdLiquids.lava){{
                damage = 20;
                speed = 4f;
                knockback = 1.3f;
                puddleSize = 8f;
                orbSize = 4f;
                drag = 0.001f;
                statusDuration = 60f * 4f;
            }}
        );
    }};
    /* Units */
    metalUnitFactory = new UnitFactory("metal-unit-factory"){{
        requirements(Category.units, with(copper, 225, lead, 155, iron,40, tin,40));
        researchCost = with(copper, 850, lead, 650, iron,500, tin,500);
        plans = Seq.with(
            new UnitPlan(pistoler, 60f * 10, with(lead,20, iron,10, aluminium,5))
        );
        size = 3;
        health = 750;
        consumePower(0.5f);
    }};
    metalT2Reconstructor = new Reconstructor("metal-t2-reconstructor"){{
        requirements(Category.units, with(copper, 325, silicon, 185, tin,165, steel,125));
        researchCost = with(copper, 1050, silicon, 750, tin,750, steel,550);
        size = 3;
        consumePower(1f);
        consumeItems(with(silicon,20, titanium, 10, steel,10));
        health = 750;
        constructTime = 60f * 10f;
        upgrades.addAll(
            new UnitType[]{pistoler, twinPistoler}
        );
    }};
    metalT3Reconstructor = new Reconstructor("metal-t3-reconstructor"){{
        requirements(Category.units, with(copper, 375, lead, 295, silicon, 225, constantan, 185, tin,185, steel,185, lithium,185));
        researchCost = with(copper, 2150, lead, 1750, silicon, 1250, constantan, 850, tin,850, steel,650, lithium,650);
        size = 5;
        consumePower(3f);
        consumeItems(with(silicon,40, constantan, 35, tin, 25, titanium, 20, steel,20));
        health = 1250;
        constructTime = 60f * 20f;
        upgrades.addAll(
            new UnitType[]{twinPistoler, multiPistoler}
        );
    }};
};
}