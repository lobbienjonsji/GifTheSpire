package theDefault.patches.animations;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.DrawMaster;
import theDefault.cards.AbstractAnimatedCard;
import theDefault.util.Animator;

/*
 * Patches have a pretty detailed documentation. Go check em out here:
 *
 *  https://github.com/kiooeht/ModTheSpire/wiki/SpirePatch
 */

@SpirePatch(clz = DrawMaster.class, method = "draw")
public class DrawMasterPatch {
    @SpirePrefixPatch
    public static void patch(DrawMaster __instance, SpriteBatch sb)
    {
        Animator.spriteBatch = sb;
    }

}