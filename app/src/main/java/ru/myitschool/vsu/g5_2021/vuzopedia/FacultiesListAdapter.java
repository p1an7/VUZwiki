package ru.myitschool.vsu.g5_2021.vuzopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import ru.myitschool.vsu.g5_2021.vuzopedia.models.facultyDescription;
import ru.myitschool.vsu.g5_2021.vuzopedia.models.vuzDescription;

public class FacultiesListAdapter extends BaseAdapter {
    private List<facultyDescription> data2= new ArrayList<>();
    public void refresh2(List<facultyDescription> d){
        data2.clear();
        if (d!=null)
            data2.addAll(d);
        notifyDataSetChanged();
    }
    public facultyDescription getFac(int position){
        return data2.get(position);
    }
    @Override
    public int getCount() {
        return data2.size();
    }

    @Override
    public Object getItem(int i) {
        return data2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final facultyDescription fac = data2.get(i);
        if (view == null) {
            view = inflater2.inflate(R.layout.faculty_list_item,null);
        }
        TextView nameTV = view.findViewById(R.id.faculty_list_item_fac_name);
        nameTV.setText(fac.name);
        return view;
    }
    private LayoutInflater inflater2;
    public FacultiesListAdapter (Context context){
        inflater2 = LayoutInflater.from(context);

    }
}
