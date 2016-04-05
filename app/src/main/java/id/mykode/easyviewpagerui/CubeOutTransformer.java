package id.mykode.easyviewpagerui;
import android.support.v4.view.*;
import android.view.*;

public class CubeOutTransformer implements ViewPager.PageTransformer
{
    public void transformPage(View view, float position) {
        final float rotation = (position < 0 ? 90f : -90f) * Math.abs(position);
        view.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
        view.setPivotX(position < 0f ? view.getWidth() : 0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(90f * position);
    }
}

