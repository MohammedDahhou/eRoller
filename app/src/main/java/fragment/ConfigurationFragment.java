package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohammeddahhou.eroller.R;
import com.kyleduo.switchbutton.SwitchButton;


public class ConfigurationFragment extends Fragment implements View.OnClickListener {

   private View view;
    private SwitchButton switch_beginner,switch_medium,switch_pro;

    public ConfigurationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_configuration, container, false);
        init();
        return view;
    }

    private void init() {
        switch_beginner = (SwitchButton) view.findViewById(R.id.switch_beginner);
        switch_medium = (SwitchButton) view.findViewById(R.id.switch_medium);
        switch_pro = (SwitchButton) view.findViewById(R.id.switch_pro);

        switch_beginner.setOnClickListener(this);
        switch_medium.setOnClickListener(this);
        switch_pro.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.switch_beginner:
                switch_pro.setChecked(false);
                switch_medium.setChecked(false);
                break;
            case R.id.switch_medium:
                switch_beginner.setChecked(false);
                switch_pro.setChecked(false);
                break;
            case R.id.switch_pro:
                switch_beginner.setChecked(false);
                switch_medium.setChecked(false);
                break;
        }
    }
}
