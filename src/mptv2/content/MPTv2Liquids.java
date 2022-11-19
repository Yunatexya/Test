package mptv2.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class MPTv2Liquids {
    public static Liquid
        meter
        ;

    public static void load(){
        meter = new Liquid("meter", Color.ValueOf("076c83")){{
            heatCapacity = 15f;
            temperature = -270f;
            viscosity = 0.000001f;
        }};
    }
}
