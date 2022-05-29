package ru.myitschool.vsu.g5_2021.vuzopedia.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.myitschool.vsu.g5_2021.vuzopedia.R;

public class SpecialityListAdapter extends BaseAdapter{
    private List<specialityDescription> data3= new ArrayList<>();
    public void refresh3(List<specialityDescription> d){
        data3.clear();
        if (d!=null)
            data3.addAll(d);
        notifyDataSetChanged();
    }
    public specialityDescription getspec (int position){
        return data3.get(position);
    }
    @Override
    public int getCount() {
        return data3.size();
    }

    @Override
    public Object getItem(int i) {
        return data3.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final specialityDescription spec = data3.get(i);
        if (view == null) {
            view = inflater3.inflate(R.layout.speciality_list_item,null);
        }
        TextView nameTV = view.findViewById(R.id.speciality_list_item_spec_name);
        nameTV.setText(spec.name);
        TextView balTV = view.findViewById(R.id.speciality_list_item_spec_bal);
        balTV.setText(spec.bal);
        return view;
    }
    private LayoutInflater inflater3;
    public SpecialityListAdapter (Context context){
        inflater3 = LayoutInflater.from(context);

    }
}


