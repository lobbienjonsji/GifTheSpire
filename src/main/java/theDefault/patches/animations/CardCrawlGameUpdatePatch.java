package theDefault.patches.animations;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import theDefault.LobLib;
import theDefault.util.GifAnimation;

import java.util.ArrayList;

@SpirePatch(clz = CardCrawlGame.class, method = "update")
public class CardCrawlGameUpdatePatch {
    @SpirePostfixPatch
    public static void patch(CardCrawlGame __instance) {
        for (GifAnimation g:LobLib.TickThis)
        {
            g.tick();
        }
    }
}
