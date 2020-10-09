package GifTheSpire.util;

import com.evacipated.cardcrawl.modthespire.lib.SpireField;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;

@SpirePatch(clz = AbstractCard.class, method = SpirePatch.CLASS)
public class CardTimerField {
    public static SpireField<Float> CardTimer = new SpireField<>(() -> 0.0F);
}

