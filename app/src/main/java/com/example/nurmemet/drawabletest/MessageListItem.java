package com.example.nurmemet.drawabletest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by nurmemet on 8/1/2016.
 */
public class MessageListItem extends RelativeLayout {
    private boolean isReaded = false;
    private static final int[] STATE_MESSAGE_READED = {R.attr.sate_readed};

    public MessageListItem(Context context) {
        super(context);
    }

    public MessageListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MessageListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MessageListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setMessageReaded(boolean isReaded) {
        if (this.isReaded ^ isReaded) {
            this.isReaded = isReaded;
            refreshDrawableState();
        }

    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        if (isReaded) {
            final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, STATE_MESSAGE_READED);
            return drawableState;
        }
        return super.onCreateDrawableState(extraSpace);
    }
}
