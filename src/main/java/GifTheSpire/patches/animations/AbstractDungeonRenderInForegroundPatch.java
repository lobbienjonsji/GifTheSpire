package GifTheSpire.patches.animations;

import GifTheSpire.LobLib;
import GifTheSpire.util.GifAnimation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import javassist.CannotCompileException;
import javassist.CtBehavior;

import java.util.ArrayList;

@SpirePatch(clz = AbstractDungeon.class, method = "render")
public class AbstractDungeonRenderInForegroundPatch {
    @SpirePostfixPatch
    public static void patch(AbstractDungeon __instance, SpriteBatch sb) {
        ArrayList<GifAnimation> Renderthis = LobLib.getAnimations().get("Foreground");
        if (Renderthis != null) {
            for (GifAnimation g : Renderthis) {
                if (g.ishidden == false) {
                    g.renderanimation(sb);
                }
            }
        }
    }
}