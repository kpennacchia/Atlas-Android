package com.layer.ui.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.layer.sdk.messaging.Message;
import com.layer.ui.recyclerview.ItemsRecyclerView;

public class MessagesRecyclerView extends ItemsRecyclerView<Message> {
    private View emptyView;
    private EmptyMessageFormatter mMessageFormatter = new EmptyMessageFormatterImpl();

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            Adapter adapter = getAdapter();
            MessagesAdapter messagesAdapter =  adapter instanceof MessagesAdapter ? (MessagesAdapter) adapter : null;
            if (messagesAdapter != null && emptyView != null) {
                if (messagesAdapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    if (emptyView instanceof TextView) {
                        String message = mMessageFormatter.createEmptyMessageListText(messagesAdapter.getParticipants(), messagesAdapter.getActiveUser());
                        ((TextView) emptyView).setText(message);
                    }
                    MessagesRecyclerView.this.setVisibility(View.GONE);
                } else {
                    removeEmptyView();
                }
            }
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            super.onItemRangeChanged(positionStart, itemCount, payload);
            removeEmptyView();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
           removeEmptyView();
        }
    };

    private void removeEmptyView() {
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
            setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        adapter.registerAdapterDataObserver(emptyObserver);
        super.setAdapter(adapter);
        emptyObserver.onChanged();
    }

    public MessagesRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MessagesRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessagesRecyclerView(Context context) {
        super(context);
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

}