package mptv2.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class MPTv2Items {
    public static Item
        //material
        metren, metrenGlass, metrenDiamond, compressedThorium,

        //resource
        unitCore, miltiCore, boosterCell, deuterium, antimatter,

        //ammo
        metrenAmmo, metrenMissile, emperorsCristal
        ;

    public static void load() {
        //material
        metren = new Item("metren", Color.valueOf("505050"));
        metrenGlass = new Item("metren-glass", Color.valueOf("bbbbbb"));
        metrenDiamond = new Item("metren-diamond", Color.valueOf("5efffa"));
        compressedThorium = new Item("compressedThorium", Color.valueOf("4f7e81")){{
            explosiveness = 0.9f;
            radioactivity = 4f;
            flammability = 1.5f;
        }};
        //resource
        unitCore = new Item("unitCore", Color.valueOf("aaaaaa"));
        miltiCore = new Item("multiCore", Color.valueOf("ffdc62"));
        boosterCell = new Item("boosterCell", Color.valueOf("e6ff00"));
        deuterium = new Item("deuteium", Color.valueOf("0f0f0f")){{
            explosiveness = 70f;
            radioactivity = 70f;
        }};
        antimatter = new Item("antimatter", Color.valueOf("0000000"));
        //ammo
        metrenAmmo = new Item("metrenAmmo", Color.valueOf("4f7e81"));
        metrenMissile = new Item("metrenMissile", Color.valueOf("4f7e81"));
        emperorsCristal = new Item("emperorsCristal", Color.valueOf("FFFFA0"));
    }
}
