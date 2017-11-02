package com.layer.atlas.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;

import com.layer.atlas.R;
import com.squareup.picasso.Transformation;

public final class AvatarStyle {

    private int mAvatarBackgroundColor;
    private int mAvatarBorderColor;
    private int mAvatarTextColor;
    private Typeface mAvatarTextTypeface;
    private Transformation mSingleTransform;
    private Transformation mMultiTransform;

    private AvatarStyle(Builder builder) {
        mAvatarBackgroundColor = builder.avatarBackgroundColor;
        mAvatarTextColor = builder.avatarTextColor;
        mAvatarTextTypeface = builder.avatarTextTypeface;
        mAvatarBorderColor = builder.avatarBorderColor;
        mSingleTransform = builder.singleTransform;
        mMultiTransform = builder.multiTransform;
    }

    public static AvatarStyle getDefaultStyle(Context context) {
        TypedArray ta = context.getTheme().obtainStyledAttributes(null, R.styleable.AtlasConversationsRecyclerView,
        R.attr.AtlasConversationsRecyclerView, 0);
        AvatarStyle.Builder avatarStyleBuilder = new AvatarStyle.Builder();
        avatarStyleBuilder.avatarTextColor(ta.getColor(R.styleable.AtlasConversationsRecyclerView_avatarTextColor,
        context.getResources().getColor(R.color.atlas_avatar_text)));
        avatarStyleBuilder.avatarBackgroundColor(ta.getColor(R.styleable.AtlasConversationsRecyclerView_avatarBackgroundColor,
        context.getResources().getColor(R.color.atlas_avatar_background)));
        avatarStyleBuilder.avatarBorderColor(ta.getColor(R.styleable.AtlasConversationsRecyclerView_avatarBorderColor,
        context.getResources().getColor(R.color.atlas_avatar_border)));
        return avatarStyleBuilder.build();
    }

    public void setAvatarTextTypeface(Typeface avatarTextTypeface) {
        this.mAvatarTextTypeface = avatarTextTypeface;
    }

    public void setAvatarBackgroundColor(int color) {
        this.mAvatarBackgroundColor = color;
    }

    public void setAvatarTextColor(int color) {
        this.mAvatarTextColor = color;
    }

    public void setAvatarBorderColor(int color) {
        this.mAvatarBorderColor = color;
    }

    public void setSingleTransform(Transformation transform) {
        this.mSingleTransform = transform;
    }

    public void setMultiTransform(Transformation transform) {
        this.mMultiTransform = transform;
    }

    public int getAvatarBackgroundColor() {
        return mAvatarBackgroundColor;
    }

    public int getAvatarTextColor() {
        return mAvatarTextColor;
    }

    public Typeface getAvatarTextTypeface() {
        return mAvatarTextTypeface;
    }

    public int getAvatarBorderColor() {
        return mAvatarBorderColor;
    }

    public Transformation getSingleTransform() {
        return mSingleTransform;
    }

    public Transformation getMultiTransform() {
        return mMultiTransform;
    }

    public static final class Builder {
        private int avatarBorderColor;
        private int avatarBackgroundColor;
        private int avatarTextColor;
        private Typeface avatarTextTypeface;
        private Transformation singleTransform;
        private Transformation multiTransform;

        public Builder() {
        }

        public Builder avatarBackgroundColor(int val) {
            avatarBackgroundColor = val;
            return this;
        }

        public Builder avatarTextColor(int val) {
            avatarTextColor = val;
            return this;
        }

        public Builder avatarTextTypeface(Typeface val) {
            avatarTextTypeface = val;
            return this;
        }

        public Builder avatarBorderColor(int val) {
            avatarBorderColor = val;
            return this;
        }

        public Builder singleTransform(Transformation transformation) {
            singleTransform = transformation;
            return this;
        }

        public Builder multiTransform(Transformation transformation) {
            multiTransform = transformation;
            return this;
        }

        public AvatarStyle build() {
            return new AvatarStyle(this);
        }
    }
}
