package liziqiang.bawei.com.liziqiang20181008;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragments extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = View.inflate(getActivity(),R.layout.layout_fragment,null);
        WaertView waertView =view.findViewById(R.id.WeartView);
        return view;
    }

}
