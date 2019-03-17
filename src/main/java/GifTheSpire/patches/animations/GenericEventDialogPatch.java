package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import GifTheSpire.util.GifAnimation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.events.GenericEventDialog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(clz = GenericEventDialog.class, method = "render")
public class GenericEventDialogPatch {
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    @SpirePostfixPatch
    public static void patch(GenericEventDialog __instance, SpriteBatch sb) {
        if (GifTheSpireLib.CurrentEvent != null) {
            ArrayList<GifAnimation> Renderthis = GifTheSpireLib.getAnimations().get(GifTheSpireLib.CurrentEvent.getClass().getName());
            if (Renderthis != null) {
                for (GifAnimation g : Renderthis) {
                    if (g.ishidden == false) {
                        g.renderAsEvent(sb);
                    }
                }
            }
        }
    }
}
