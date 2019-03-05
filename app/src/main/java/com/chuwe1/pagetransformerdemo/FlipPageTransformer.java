package com.chuwe1.pagetransformerdemo;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ViewPager翻转切换效果
 */

public class FlipPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        //不可见的部分
        if (position < -1 || position > 1) {
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setRotationY(0);
        } else if (-1 <= position && position < 0) { //进场动画
            page.setAlpha(1 + position);
            page.setTranslationX(-position * page.getWidth());
            page.setRotationY(180 * position);
        } else if (0 < position && position <= 1) {//出场动画
            page.setAlpha(1 - position);
            page.setTranslationX(-position * page.getWidth());
            page.setRotationY(180 * position);
        } else {
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setRotationY(0);

        }
    }
}
