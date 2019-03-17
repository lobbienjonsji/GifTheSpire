package GifTheSpire.patches.animations;

import GifTheSpire.GifTheSpireLib;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import GifTheSpire.util.GifAnimation;

@SpirePatch(clz = CardCrawlGame.class, method = "update")
public class CardCrawlGameUpdatePatch {
    @SpirePostfixPatch
    public static void patch(CardCrawlGame __instance) {
        for (GifAnimation g: GifTheSpireLib.TickThis)
        {
            g.tick();
        }
    }
}
