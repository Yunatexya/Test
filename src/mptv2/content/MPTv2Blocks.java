package mptv2.content;

import static mindustry.type.ItemStack.with;

import arc.graphics.Color;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PointDefenseTurret;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.meta.BuildVisibility;

public class MPTv2Blocks {
    public static Block
        //
        //walls
        metrenWall, metrenWallLarge,

        //turrets
        emperorOfGuardian, guardian, assaultCannon, missileSilo, defendTurret, railgun, multiRailgun,

        //factory
        metrenSmelter, metrenMultiSmelter, thoriumCompressor,

        //ammo crafter
        metrenAmmoCrafter, metrenMissileCrafter,

        //Liquid factory
        meterMixer, meterMultiMixer,

        //distripution
        metrenConveyor, metrenRouter, metrenJunction, metrenBridgeConveyor, metrenUnLoader,

        //liquids
        metrenConduit, metrenArmedConduit, metrenLiquidRouter, metrenTank, metrenTankLarge,

        //power nodes
        metrenNode, metrenTowerNode,
        //batterys
        metrenBattery, metrenBatteryLarge,
        //power generators
        metrenReactor, antimatterReactor,

        //effects
        metrender, boostDriveProjector, metrenShildDome, metrenContainer,

        //coreBlock
        coreMetren, coreMetrenLarge,

        //production
        metrenMiniDrill, metrenDrill, miner,

        //units
        rommbaFactory, tankFactory, floatingShipFactory, aircraftFactory

        //original category
        ;

    private static void loadTurrets(){

        // assaultCannon = new ItemTurret("assaultCannon"){{
        //     size = 2;
        //     health = 8000000;
        //     range = 960;
        // }};

        defendTurret = new PointDefenseTurret("defendTurret"){{
            size = 2;
            health = 8000000;
            range = 400;
            coolant = consumeCoolant(0.4f);
            hasPower = true;
            consumePowerCond(8f, (PointDefenseBuild b) -> b.target != null);

            shootLength = 10f;
            bulletDamage = 100f;
            reload = 7.5f;
            requirements(Category.turret, BuildVisibility.shown, with(MPTv2Items.metren, 32, MPTv2Items.metrenDiamond, 5));
        }};

        railgun = new ItemTurret("railgun"){{
            size = 4;
            health = 32000000;
            range = 8000;
            hasPower = true;
        }};

        // multiRailgun = new ItemTurret("multiRailgun"){{
        //     size = 5;
        //     health = 50000000;
        //     range = 8000;
        //     hasPower = true;
        // }};

        // guardian = new ItemTurret("guardian"){{
        //     size = 7;
        //     health = 98000000;
        //     range = 6400;
        //     hasPower = true;
        // }};

        emperorOfGuardian = new ItemTurret("emperorOfGuardian"){{
            size = 11;
            health = 242000000;
            range = 12000;
            hasPower = true;
            shake = 0;
            ammo(
                MPTv2Items.metrenAmmo, new BasicBulletType(30, 9999999){{
                    width = 6;
                    height = 15;
                    hitColor = backColor = lightColor = trailColor = MPTv2Items.metrenAmmo.color.cpy().lerp(Color.white, 0.2f);
                    frontColor = backColor.cpy().lerp(Color.white, 0.55f);
                    ammoMultiplier = 20;
                    pierceArmor = true;
                }},
                MPTv2Items.emperorsCristal, new BasicBulletType(55, 999999999){{
                    width = 20;
                    height = 20;
                    frontColor = backColor = MPTv2Items.emperorsCristal.color.cpy().lerp(Color.white, 0.1f);
                    hitColor = lightColor = trailColor = MPTv2Items.emperorsCristal.color.cpy().lerp(Color.white, 0.4f);
                    ammoMultiplier = 1;
                    pierceArmor = true;
                    splashDamage = 150000;
                    splashDamageRadius = 500;
                }}
            );
            maxAmmo = 400;
            ammoPerShot = 5;
            consumePower(570F);
            requirements(Category.turret, with(MPTv2Items.metren, 1936, MPTv2Items.metrenDiamond, 290));
        }};
    }

    private static void loadPower() {
        antimatterReactor = new PowerGenerator("antimatterReactor"){{
            size = 7;
            health = 98000000;
            itemCapacity = 210;
            powerProduction = 2147483647;
            consumeItems(new ItemStack(MPTv2Items.deuterium, 1));
        }};
    }

    public static void load() {
        metrenWall = new Wall("metren-wall"){{
            size = 1;
            health = 2000000;
            armor = 10f;
            requirements(Category.defense, with(MPTv2Items.metren, 8));
        }};

        metrenWallLarge = new Wall("metrenWallLarge"){{
            size = 2;
            health = 8000000;
            armor = 20f;
            requirements(Category.defense, with(MPTv2Items.metren, 32));
        }};

        loadTurrets();
        loadPower();
    }
}
