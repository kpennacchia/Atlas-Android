package com.layer.ui.message;

import com.layer.sdk.messaging.Identity;

import java.util.Set;

public class EmptyMessageFormatterImpl implements EmptyMessageFormatter {

    @Override
    public String createEmptyMessageListText(Set<Identity> participants, Identity authenticatedUser) {
        int counter = 1;
        String emptyMessage = "Start a Conversation with";

        participants.remove(authenticatedUser);

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
}
