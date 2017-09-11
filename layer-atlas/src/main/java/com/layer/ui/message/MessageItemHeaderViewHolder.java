package com.layer.ui.message;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.layer.sdk.messaging.Message;
import com.layer.ui.adapters.ItemViewHolder;
import com.layer.ui.databinding.UiMessageItemHeaderBinding;
import com.layer.ui.message.messagetypes.MessageStyle;

public class MessageItemHeaderViewHolder extends
        ItemViewHolder<Message, MessageItemViewModel, ViewDataBinding, MessageStyle> {
    ViewGroup root;

    public MessageItemHeaderViewHolder(ViewDataBinding binding, MessageItemViewModel viewModel) {
        super(binding, viewModel);
        root = ((UiMessageItemHeaderBinding) binding).root;
    }

    public void bind(int viewResourceFile) {
        if (viewResourceFile != -1) {
            LayoutInflater.from(root.getContext()).inflate(viewResourceFile, root, true);
        }
    }
}
