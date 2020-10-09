package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import GifTheSpire.util.GifAnimation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(clz = AbstractMonster.class, method = "render")
public class RenderMonsterPatch {
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    @SpirePrefixPatch
    public static void patch(AbstractMonster __instance, SpriteBatch sb) {
        ArrayList<GifAnimation> Renderthis = GifTheSpireLib.getAnimations().get(__instance.id);
        if (Renderthis != null) {
            for (GifAnimation g : Renderthis) {
                if (g.ishidden == false) {
                        g.renderOverCreature(sb, __instance);
                }
            }
        }
    }
}
