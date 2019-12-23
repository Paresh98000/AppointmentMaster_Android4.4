package com.spksolutions.appointmentmaster;

import androidx.appcompat.app.AppCompatActivity;
import com.spksolutions.appointmentmaster.R;

import android.app.SearchManager;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.widget.Toast;
import android.provider.SearchRecentSuggestions;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    public void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(getApplicationContext(),query,Toast.LENGTH_LONG).show();

            SearchRecentSuggestions suggestionsProvider = new SearchRecentSuggestions(this,ContentProviderForSearchSuggestion.AUTHORITY,ContentProviderForSearchSuggestion.MODE);
            suggestionsProvider.saveRecentQuery(query,null);
        }
    }
}
