package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohammeddahhou.eroller.R;


public class AutonomieFragment extends Fragment {

   private View view;

    public AutonomieFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_autonomie_layout, container, false);
        return view;
    }



}
