package mptv2;

import java.*;
import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;
import mptv2.content.MPTv2Blocks;
import mptv2.content.MPTv2Items;

public class MPTv2ModRE extends Mod{

    public MPTv2ModRE(){
        Log.info("Loaded MPTv2-Mod-RE constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("mptv2-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        {
            MPTv2Liquids.load();
            MPTv2Items.load();
            MPTv2Blocks.load();
        }
        Log.info("Loading some mptv2 content.");
    }

}
