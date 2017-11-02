package com.layer.ui.message;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.layer.ui.R;
import com.layer.ui.databinding.UiEmptyMessageItemBinding;

public final class EmptyMessageListHeaderView extends FrameLayout {
    private UiEmptyMessageItemBinding mUiEmptyMessageItemsListBinding;

    public EmptyMessageListHeaderView(Context context) {
        this(context, null);
    }

    public EmptyMessageListHeaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyMessageListHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        mUiEmptyMessageItemsListBinding =
                DataBindingUtil.inflate(inflater, R.layout.ui_empty_message_item, this,
                        true);
    }

    public UiEmptyMessageItemBinding getUiEmptyMessageItemsListBinding() {
        return mUiEmptyMessageItemsListBinding;
    }
}
