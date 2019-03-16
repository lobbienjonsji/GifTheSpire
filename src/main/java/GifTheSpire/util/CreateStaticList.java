package GifTheSpire.util;

import java.util.ArrayList;

public class CreateStaticList {
    public static ArrayList<String> PutintoList(String[] Frames)
    {
        ArrayList<String> Returnthis = new ArrayList<>();
        for(int i = 0; i < Frames.length; i++)
        {
            Returnthis.add(Frames[i]);
        }
        return Returnthis;
    }
}
