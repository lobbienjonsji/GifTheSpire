package theDefault.patches.animations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoom;
import theDefault.LobLib;
import theDefault.util.GifAnimation;

import java.util.ArrayList;

@SpirePatch(clz = AbstractCard.class, method = "renderPortrait")
public class RenderPortraitPatch {
    @SpirePostfixPatch
    public static void patch(AbstractCard __instance, SpriteBatch sb) {
        ArrayList<GifAnimation> Renderthis = LobLib.getAnimations().get(__instance.cardID);
        if (Renderthis != null) {
            float drawX = __instance.current_x - 125.0F;
            float drawY = __instance.current_y - 95.0F;
            for (GifAnimation g : Renderthis) {
                g.renderAsPortrait(sb, __instance.angle, 250, 190, drawX*1.0F, drawY + 72.0F,125.0F, 23.0F,__instance.drawScale*Settings.scale, __instance.drawScale*Settings.scale);
            }
        }
    }
}
