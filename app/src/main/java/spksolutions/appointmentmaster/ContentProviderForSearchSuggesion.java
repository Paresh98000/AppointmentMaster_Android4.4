package spksolutions.appointmentmaster;

import android.content.SearchRecentSuggestionsProvider;

public class ContentProviderForSearchSuggesion extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "spksolutions.appointmentmaster.suggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public ContentProviderForSearchSuggesion() {
        setupSuggestions(AUTHORITY,MODE);
    }
}
