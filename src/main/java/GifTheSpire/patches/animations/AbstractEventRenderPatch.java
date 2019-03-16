package GifTheSpire.patches.animations;

import GifTheSpire.LobLib;
import GifTheSpire.util.GifAnimation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@SpirePatch(clz = AbstractImageEvent.class, method = "render")
public class AbstractEventRenderPatch {
    public static final Logger logger = LogManager.getLogger(LobLib.class.getName());
    @SpirePostfixPatch
    public static void patch(AbstractImageEvent __instance, SpriteBatch sb) {
        LobLib.CurrentEvent = __instance;
    }
}
