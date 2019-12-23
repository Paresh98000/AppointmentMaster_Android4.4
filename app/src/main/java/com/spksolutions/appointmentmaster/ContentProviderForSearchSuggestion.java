package com.spksolutions.appointmentmaster;

import android.content.SearchRecentSuggestionsProvider;

public class ContentProviderForSearchSuggestion extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "com.spksolutions.appointmentmaster.suggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public ContentProviderForSearchSuggestion() {
        setupSuggestions(AUTHORITY,MODE);
    }
}
