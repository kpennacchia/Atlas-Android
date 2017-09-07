package com.layer.ui.message;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.layer.sdk.LayerClient;
import com.layer.sdk.messaging.Identity;
import com.layer.sdk.messaging.Message;
import com.layer.ui.message.messagetypes.CellFactory;
import com.layer.ui.util.DateFormatter;
import com.layer.ui.util.imagecache.ImageCacheWrapper;
import com.layer.ui.util.views.SwipeableItem;

import java.util.List;
import java.util.Set;

public class MessageItemsListViewModel extends BaseObservable {
    protected MessagesAdapter mMessageItemsAdapter;
    protected List<CellFactory> mCellFactories;
    protected SwipeableItem.OnItemSwipeListener<Message> mItemSwipeListener;
    protected boolean mIsMessageSizeZero;
    protected String emptyMessageText;
    private LayerClient mLayerClient;

    protected MessagesAdapter.MessageAdapterEmptyRegister mMessageAdapterEmptyRegister = new MessagesAdapter.MessageAdapterEmptyRegister() {
        @Override
        public void setIsMessageSizeZero(boolean isMessageSizeZero, Set<Identity> participants) {
            mIsMessageSizeZero = isMessageSizeZero;
            if (participants != null) {
                emptyMessageText = createEmptyMessageListText(participants);
            }
            notifyChange();
        }
    };

    private String createEmptyMessageListText(Set<Identity> participants) {
        int counter = 1;
        String emptyMessage = "Start a Conversation with";

        participants.remove(mLayerClient.getAuthenticatedUser());

        boolean hasTwoParticipants = participants.size() == 2;
        for (Identity participant : participants) {

            if (counter ==2) {
                emptyMessage = emptyMessage + (hasTwoParticipants ? " and " : ", ") + participant.getDisplayName();
                break;
            }
            emptyMessage = emptyMessage + " " + participant.getDisplayName();
            counter++;
        }
        int remainder = participants.size() - 2;
        if (!hasTwoParticipants && remainder > 0) {
            emptyMessage = remainder > 0 ? emptyMessage + " and "
                    + (remainder ==1 ? " one person " : remainder + " others")
                    : emptyMessage;
        }
        return emptyMessage;
    }

    public MessageItemsListViewModel(Context context, LayerClient layerClient,
            ImageCacheWrapper imageCacheWrapper, DateFormatter dateFormatter) {
        mLayerClient = layerClient;
        mMessageItemsAdapter = new MessagesAdapter(context, layerClient, imageCacheWrapper, dateFormatter);
        mMessageItemsAdapter.setMessageAdapterEmptyRegister(mMessageAdapterEmptyRegister);
    }

    @Bindable
    public MessagesAdapter getMessageItemsAdapter() {
        return mMessageItemsAdapter;
    }

    @Bindable
    public List<CellFactory> getCellFactories() {
        return mCellFactories;
    }

    public void setCellFactories(List<CellFactory> cellFactories) {
        mCellFactories = cellFactories;
    }

    public void setOnItemSwipeListener(SwipeableItem.OnItemSwipeListener<Message> onItemSwipeListener) {
        mItemSwipeListener = onItemSwipeListener;
    }

    public SwipeableItem.OnItemSwipeListener<Message> getItemSwipeListener() {
        return mItemSwipeListener;
    }

    @Bindable
    public boolean getIsMessageSizeZero() {
        return mIsMessageSizeZero;
    }

    @Bindable
    public String getEmptyMessageText() {
        return emptyMessageText;
    }
}
