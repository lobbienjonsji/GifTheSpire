package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import GifTheSpire.util.GifAnimation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(clz = AbstractPlayer.class, method = "renderPlayerImage")
public class RenderPlayerImagePatch {
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    @SpirePrefixPatch
    public static SpireReturn patch(AbstractPlayer __instance, SpriteBatch sb) {
        ArrayList<GifAnimation> Renderthis = GifTheSpireLib.getAnimations().get(__instance.getClass().getName());
        if (Renderthis != null) {
            for (GifAnimation g : Renderthis) {
                if (g.ishidden == false) {
                    g.renderOverCharacter(sb, __instance);
                }
            }
            return SpireReturn.Return(null);
        }
        else {
            return SpireReturn.Continue();
        }
    }
}
