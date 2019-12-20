package spksolutions.appointmentmaster.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import spksolutions.appointmentmaster.R;
import spksolutions.appointmentmaster.adapter.Recycle_Home;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView mR_View;
    private RecyclerView.Adapter mR_Adapter;
    private RecyclerView.LayoutManager mR_LayoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mR_View = root.findViewById(R.id.recyclerview_home);
        mR_View.setHasFixedSize(true);

        mR_LayoutManager = new LinearLayoutManager(getActivity());
        mR_View.setLayoutManager(mR_LayoutManager);

        Recycle_Home adapter = new Recycle_Home(new String[]{"Hellow","Paresh"},new String[]{"Hi...","Desc"},new String[]{"Hi...","Add"},new String[]{"Hi...",""},new int[]{R.drawable.appointment_1,R.drawable.appointment});
        mR_View.setAdapter(adapter);

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}