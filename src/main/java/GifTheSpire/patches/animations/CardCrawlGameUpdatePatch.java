package GifTheSpire.patches.animations;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import GifTheSpire.LobLib;
import GifTheSpire.util.GifAnimation;

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
