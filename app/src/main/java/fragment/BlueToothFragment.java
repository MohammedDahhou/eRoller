package fragment;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohammeddahhou.eroller.R;

import java.util.ArrayList;
import java.util.Set;


public class BlueToothFragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_ENABLE_BT = 88;
    private View view;

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button_on)
            on();
        else if (view.getId()==R.id.button_off)
            off();
        else if (view.getId()==R.id.button_list)
            list();
        else
            visible();

    }

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    private ListView lv;
    private Button b_on,b_off,b_list,b_visibility;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_bluetooth_layout, container, false);
        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) view.findViewById(R.id.listView);
        b_on = (Button) view.findViewById(R.id.button_on);
        b_off=(Button) view.findViewById(R.id.button_off);
        b_list=(Button) view.findViewById(R.id.button_list);
        b_visibility=(Button) view.findViewById(R.id.button_visible);
        b_on.setOnClickListener(this);
        b_off.setOnClickListener(this);
        b_list.setOnClickListener(this);
        b_visibility.setOnClickListener(this);
        return view;
    }
    public void on(){
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            BA.enable();
            Toast.makeText(getActivity(), "Turned on",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Already on", Toast.LENGTH_LONG).show();
        }
    }

    public void off(){
        BA.disable();
        Toast.makeText(getActivity(), "Turned off" ,Toast.LENGTH_LONG).show();

    }


    public  void visible(){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        Toast.makeText(getActivity(), "your devise is visibles" ,Toast.LENGTH_LONG).show();
        startActivityForResult(getVisible, 0);
    }


    public void list(){
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice bt : pairedDevices) list.add(bt.getName()+" :"+bt.getAddress());
            final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        }
    }


}
