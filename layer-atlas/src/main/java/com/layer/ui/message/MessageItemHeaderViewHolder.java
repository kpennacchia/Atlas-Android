package com.layer.ui.message;

import android.databinding.ViewDataBinding;

import com.layer.sdk.messaging.Message;
import com.layer.ui.adapters.ItemViewHolder;
import com.layer.ui.databinding.UiMessageItemHeaderBinding;
import com.layer.ui.message.messagetypes.MessageStyle;

public class MessageItemHeaderViewHolder extends
        ItemViewHolder<Message, MessageItemViewModel, ViewDataBinding, MessageStyle> {

    public MessageItemHeaderViewHolder(ViewDataBinding binding, MessageItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public void bind() {
        super.getViewModel().notifyChange();
        ((UiMessageItemHeaderBinding) mBinding).setViewModel(super.getViewModel());
    }
}
