package GifTheSpire;

import basemod.BaseMod;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.characters.Defect;
import com.megacrit.cardcrawl.events.AbstractEvent;
import com.megacrit.cardcrawl.events.exordium.Sssserpent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import GifTheSpire.util.GifAnimation;
import GifTheSpire.util.IDCheckDontTouchPls;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

@SpireInitializer
public class GifTheSpireLib implements
        PostInitializeSubscriber {
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    private static String modID;
    public static HashMap<String, ArrayList<GifAnimation>> Animations = new HashMap<>();
    //public static GifAnimation FreeRealEstate = new GifAnimation("GifTheSpireResources/images/other/freerealestatepritesheet.png", 5, 17, 0, 0, 2.0F, 2.0F, false );
    public static ArrayList<GifAnimation> TickThis = new ArrayList<>();
    public static AbstractEvent CurrentEvent = null;
    public GifTheSpireLib() {
        BaseMod.subscribe(this);
        setModID("Loblib");
    }
    public static void setModID(String ID) { // DON'T EDIT
        Gson coolG = new Gson(); // EY DON'T EDIT THIS
        //   String IDjson = Gdx.files.internal("IDCheckStrings.json").readString(String.valueOf(StandardCharsets.UTF_8)); // i hate u Gdx.files
        InputStream in = GifTheSpireLib.class.getResourceAsStream("/IDCheckStrings.json"); // DON'T EDIT THIS ETHER
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class); // OR THIS, DON'T EDIT IT

        if (ID.equals(EXCEPTION_STRINGS.DEFAULTID)) { // DO *NOT* CHANGE THIS ESPECIALLY, TO EDIT YOUR MOD ID, SCROLL UP JUST A LITTLE, IT'S JUST ABOVE
            throw new RuntimeException(EXCEPTION_STRINGS.EXCEPTION); // THIS ALSO DON'T EDIT
        } else if (ID.equals(EXCEPTION_STRINGS.DEVID)) { // NO
            modID = EXCEPTION_STRINGS.DEFAULTID; // DON'T
        } else { // NO EDIT AREA
            modID = ID; // DON'T WRITE OR CHANGE THINGS HERE NOT EVEN A LITTLE
        } // NO
    } // NO

    public static String getModID() { // NO
        return modID; // DOUBLE NO
    } // NU-UH

    private static void pathCheck() { // ALSO NO
        Gson coolG = new Gson(); // NNOPE DON'T EDIT THIS
        //   String IDjson = Gdx.files.internal("IDCheckStrings.json").readString(String.valueOf(StandardCharsets.UTF_8)); // i still hate u btw Gdx.files
        InputStream in = GifTheSpireLib.class.getResourceAsStream("/IDCheckStrings.json"); // DON'T EDIT THISSSSS
        IDCheckDontTouchPls EXCEPTION_STRINGS = coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class); // NAH, NO EDIT

        String packageName = GifTheSpireLib.class.getPackage().getName(); // STILL NOT EDIT ZONE
        FileHandle resourcePathExists = Gdx.files.internal(getModID() + "Resources"); // PLEASE DON'T EDIT THINGS HERE, THANKS
        if (!modID.equals(EXCEPTION_STRINGS.DEVID)) { // LEAVE THIS EDIT-LESS
            if (!packageName.equals(getModID())) { // NOT HERE ETHER
                throw new RuntimeException(EXCEPTION_STRINGS.PACKAGE_EXCEPTION + getModID()); // THIS IS A NO-NO
            } // WHY WOULD U EDIT THIS
            if (!resourcePathExists.exists()) { // DON'T CHANGE THIS
                throw new RuntimeException(EXCEPTION_STRINGS.RESOURCE_FOLDER_EXCEPTION + getModID() + "Resources"); // NOT THIS
            }// NO
        }// NO
    }// NO
    // ====== YOU CAN EDIT AGAIN ======

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("Initializing GifMod ö/");
        GifTheSpireLib defaultmod = new GifTheSpireLib();
        logger.info("");
    }
    @Override
    public void receivePostInitialize() {
        logger.info("Creating Gifs");
        //FreeRealEstate.create();
        //FreeRealEstate.addAsBackgroundAnimation();
        //FreeRealEstate.addAsCardAnimation("Strike_R");
        //FreeRealEstate.addAsEventAnimation(Sssserpent.class.getName());
        //FreeRealEstate.addAsForeGroundAnimation();
        //FreeRealEstate.addAsCharacterAnimation(Defect.class.getName());
    }

    public static HashMap<String, ArrayList<GifAnimation>> getAnimations()
    {
        return Animations;
    }
    public static String makeID(String idText) {
        return getModID() + ":" + idText;
    }
}
