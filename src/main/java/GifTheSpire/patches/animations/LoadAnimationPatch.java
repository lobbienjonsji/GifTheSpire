package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import GifTheSpire.util.GifAnimation;
import basemod.ReflectionHacks;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.screens.SingleCardViewPopup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(clz = AbstractCreature.class, method = "loadAnimation")
public class LoadAnimationPatch {
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    @SpirePostfixPatch
    public static void patch(AbstractCreature __instance, String atlasUrl, String skeletonUrl, float scale) {
        ArrayList<GifAnimation> Renderthis = GifTheSpireLib.getAnimations().get(__instance.id);
        if (Renderthis != null && __instance instanceof AbstractMonster) {
            ReflectionHacks.setPrivate(__instance, AbstractCreature.class, "atlas", null);
        }
    }
}
