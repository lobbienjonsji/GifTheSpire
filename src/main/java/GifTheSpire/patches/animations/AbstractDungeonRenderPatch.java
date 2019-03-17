package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import GifTheSpire.util.GifAnimation;
import com.megacrit.cardcrawl.rooms.*;

import java.util.ArrayList;


@SpirePatch(clz = AbstractDungeon.class, method = "render")
public class AbstractDungeonRenderPatch {
    @SpireInsertPatch(locator = Locator.class)
    public static void patch(AbstractDungeon __instance, SpriteBatch sb) {
        ArrayList<GifAnimation> Renderthis = GifTheSpireLib.getAnimations().get("Background");
        if (Renderthis != null) {
            for (GifAnimation g : Renderthis) {
                if (AbstractDungeon.getCurrRoom() instanceof MonsterRoom) {
                    g.ishidden = false;
                } else {
                    g.ishidden = true;
                }
                if (g.ishidden == false) {
                    g.renderAsBackground(sb);
                }
            }
        }
    }
    private static class Locator extends SpireInsertLocator {
         public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException {
            Matcher finalMatcher = new Matcher.FieldAccessMatcher(
                    AbstractDungeon.class, "dynamicButton");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<Matcher>(), finalMatcher);
        }
    }

}