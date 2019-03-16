package theDefault.util;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.megacrit.cardcrawl.helpers.ImageMaster;

public class AbstractAnimation implements ApplicationListener {
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
    public AbstractAnimation(String imgurl, int columns, int rows, float x, float y, float stretchx, float stretchy, boolean ishiddeninitially)
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
    }
    public void renderanimation(SpriteBatch sb) {
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        TextureRegion currentFrame = GifAnimation.getKeyFrame(stateTime, true);
        sb.setColor(Color.WHITE);
        sb.draw(currentFrame, currentx, currenty, widthmodfier, heightmodifier); // Draw current frame at (50, 50)
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
