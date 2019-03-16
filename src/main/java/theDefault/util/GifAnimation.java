package theDefault.util;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import theDefault.LobLib;

import java.util.ArrayList;

public class GifAnimation implements ApplicationListener {
    static Animation<TextureRegion> GifAnimation;
    Texture TextureReg;
    float stateTime;
    public float currentx;
    public float currenty;
    public float widthmodfier;
    public float heightmodifier;
    private int clms;
    private int rows;
    private String txt;
    public boolean ishidden;
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
        LobLib.TickThis.add(this);
    }
    public void tick()
    {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    public void renderanimation(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, currentx, currenty, /*(currentFrame.getTexture().getWidth()/clms)*widthmodfier, (currentFrame.getTexture().getHeight()/rows)*heightmodifier*/ Settings.WIDTH, Settings.HEIGHT);
    }
    public void renderAsBackground(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, currentx, currenty, Settings.WIDTH, Settings.HEIGHT);
    }
    public void renderAsPortrait(SpriteBatch sb, float angle, float sizex, float sizey, float posx, float posy, float originx, float originy, float scalex, float scaley) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, posx, posy,originx, originy, sizex, sizey, scalex, scaley, angle);
    }

    public void renderanimationonce(SpriteBatch sb) {
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, false);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, currentx, currenty, (currentFrame.getTexture().getWidth()/clms)*widthmodfier, (currentFrame.getTexture().getHeight()/rows)*heightmodifier);
    }

    public void addAsBackgroundAnimation()
    {
        if(LobLib.Animations.containsKey("Background"))
        {
            LobLib.Animations.get("Background").add(this);
        }
        else
        {
            LobLib.Animations.put("Background", new ArrayList<>());
            LobLib.Animations.get("Background").add(this);
        }
    }
    public void addAsCardAnimation(String Card)
    {
        if(LobLib.Animations.containsKey(Card))
        {
            LobLib.Animations.get(Card).add(this);
        }
        else
        {
            LobLib.Animations.put(Card, new ArrayList<>());
            LobLib.Animations.get(Card).add(this);
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
