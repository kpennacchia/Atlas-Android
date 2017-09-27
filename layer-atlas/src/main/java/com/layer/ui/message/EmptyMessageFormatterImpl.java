package com.layer.ui.message;

import com.layer.sdk.messaging.Identity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmptyMessageFormatterImpl implements EmptyMessageFormatter {

    @Override
    public String createEmptyMessageListText(Set<Identity> participants, Identity authenticatedUser) {

        if (participants.size() == 0 || authenticatedUser == null) return "";
        String emptyMessage = "Start a Conversation with";
        participants.remove(authenticatedUser);
        List<Identity> participantList = new ArrayList<>(participants);

        if (participants.size() == 1 ) {
            emptyMessage = emptyMessage + " " + participantList.get(0).getDisplayName();
        } else if (participants.size() == 2) {
            emptyMessage = emptyMessage + " " + participantList.get(0).getDisplayName() + " & " + participantList.get(1).getDisplayName();
        } else if (participants.size() == 3) {
            emptyMessage = emptyMessage + " " + participantList.get(0).getDisplayName() + ", " + participantList.get(1).getDisplayName() + " & " + "one other";
        } else {
            int remainder = participantList.size() - 2;
            emptyMessage = emptyMessage + " " + participantList.get(0).getDisplayName() + ", " + participantList.get(1).getDisplayName() + " & " + remainder +" others";
        }

        return emptyMessage;
    }
}
