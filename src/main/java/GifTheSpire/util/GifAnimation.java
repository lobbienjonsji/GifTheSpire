package GifTheSpire.util;

import GifTheSpire.GifTheSpireLib;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class GifAnimation implements ApplicationListener {
    private Animation<TextureRegion> GifAnimation;
    Texture TextureReg;
    float stateTime;
    public float currentx;
    public float currenty;
    public float widthmodfier;
    public float heightmodifier;
    private int clms;
    private int rows;
    private String txt;
    private float framedur = 0.025F;
    public boolean ishidden;
    public static SpriteBatch getSpritebatch = null;
    public static final Logger logger = LogManager.getLogger(GifTheSpireLib.class.getName());
    public GifAnimation(String imgurl, int columns, int rows, float x, float y, float stretchx, float stretchy, boolean ishiddeninitially)
    {
        currentx = x;
        currenty = y;
        txt = imgurl;
        clms = columns;
        this.rows = rows;
        ishidden = ishiddeninitially;
        heightmodifier = stretchy;
        widthmodfier = stretchx;
    }

    @Override
    public void create() {
        TextureReg = ImageMaster.loadImage(txt);;
        TextureRegion[][] tmp = TextureRegion.split(TextureReg,
                TextureReg.getWidth() / clms,
                TextureReg.getHeight() / rows);

        TextureRegion[] Frames = new TextureRegion[clms * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clms; j++) {
                Frames[index++] = tmp[i][j];
            }
        }
        GifAnimation = new Animation<TextureRegion>(0.025f, Frames);
        stateTime = 0f;
        GifTheSpireLib.TickThis.add(this);
    }
    public void tick()
    {
        stateTime += Gdx.graphics.getDeltaTime();
    }
    public void setAnimationspeed(float spf)
    {
        GifAnimation.setFrameDuration(spf);
    }
    public void renderanimation(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, currentx*Settings.scale, currenty*Settings.scale, (currentFrame.getTexture().getWidth()/clms)*widthmodfier*Settings.scale, (currentFrame.getTexture().getHeight()/rows)*heightmodifier*Settings.scale /*Settings.WIDTH, Settings.HEIGHT*/);
    }
    public void renderAsBackground(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, 0, 0, Settings.WIDTH, Settings.HEIGHT);
    }
    public void renderAsPortrait(SpriteBatch sb, float angle, float sizex, float sizey, float posx, float posy, float originx, float originy, float scalex, float scaley) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, posx, posy,originx, originy, sizex, sizey, scalex, scaley, angle);
    }
    public void renderAsEvent(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, (460.0F*Settings.scale + (600.0F-(currentFrame.getTexture().getWidth()/clms)*widthmodfier*Settings.scale)/2.0F) - 300.0F,  (Settings.EVENT_Y - 300.0F + 16.0F * Settings.scale)+(600.0F -(currentFrame.getTexture().getHeight()/rows*heightmodifier*Settings.scale))/2.0F, (currentFrame.getTexture().getWidth()/clms)*widthmodfier*Settings.scale, (currentFrame.getTexture().getHeight()/rows)*heightmodifier*Settings.scale);
    }
    public void renderOverCharacter(SpriteBatch sb, AbstractPlayer a) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        getSpritebatch.setColor(Color.WHITE);
        getSpritebatch.draw(currentFrame, a.drawX - (currentFrame.getTexture().getWidth()/clms)*widthmodfier*Settings.scale*0.5F + a.animX, a.drawY, (currentFrame.getTexture().getWidth()/clms)*widthmodfier*Settings.scale, (currentFrame.getTexture().getHeight()/rows)*heightmodifier*Settings.scale);
    }
    public void addAsBackgroundAnimation()
    {
        if(GifTheSpireLib.Animations.containsKey("Background"))
        {
            GifTheSpireLib.Animations.get("Background").add(this);
        }
        else
        {
            GifTheSpireLib.Animations.put("Background", new ArrayList<>());
            GifTheSpireLib.Animations.get("Background").add(this);
        }
    }
    public void addAsCardAnimation(String Card)
    {
        if(GifTheSpireLib.Animations.containsKey(Card))
        {
            GifTheSpireLib.Animations.get(Card).add(this);
        }
        else
        {
            GifTheSpireLib.Animations.put(Card, new ArrayList<>());
            GifTheSpireLib.Animations.get(Card).add(this);
        }
    }
    public void addAsEventAnimation(String Event)
    {
        if(GifTheSpireLib.Animations.containsKey(Event))
        {
            GifTheSpireLib.Animations.get(Event).add(this);
        }
        else
        {
            GifTheSpireLib.Animations.put(Event, new ArrayList<>());
            GifTheSpireLib.Animations.get(Event).add(this);
        }
    }
    public void addAsForeGroundAnimation()
    {
        if(GifTheSpireLib.Animations.containsKey("Foreground"))
        {
            GifTheSpireLib.Animations.get("Foreground").add(this);
        }
        else
        {
            GifTheSpireLib.Animations.put("Foreground", new ArrayList<>());
            GifTheSpireLib.Animations.get("Foreground").add(this);
        }
    }
    public void addAsCharacterAnimation(String ChosenClass)
    {
        if(GifTheSpireLib.Animations.containsKey(ChosenClass))
        {
            GifTheSpireLib.Animations.get(ChosenClass).add(this);
        }
        else
        {
            GifTheSpireLib.Animations.put(ChosenClass, new ArrayList<>());
            GifTheSpireLib.Animations.get(ChosenClass).add(this);
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
