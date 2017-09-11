package com.layer.ui.message;

import com.layer.sdk.messaging.Identity;

import java.util.Set;

public interface EmptyMessageFormatter {
    String createEmptyMessageListText(Set<Identity> participants, Identity authenticatedUser);
}
