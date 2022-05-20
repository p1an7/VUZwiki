package ru.myitschool.vsu.g5_2021.vuzopedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.myitschool.vsu.g5_2021.vuzopedia.models.vuzDescription;

public class VuzesListAdapter extends BaseAdapter {
    private List<vuzDescription> data = new ArrayList<>();
    public void refresh(List<vuzDescription> d){
        data.clear();
        if (d!=null)
            data.addAll(d);
        notifyDataSetChanged();
    }
    public vuzDescription getVuz(int position){
        return data.get(position);
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final vuzDescription vuz = data.get(i);
        if (view == null) {
            view = inflater.inflate(R.layout.vuzes_list_item,null);
        }
        TextView nameTV = view.findViewById(R.id.vuzes_list_item_vuz_name);
        nameTV.setText(vuz.name);
        return view;
    }
    private LayoutInflater inflater;
    public VuzesListAdapter (Context context){
        inflater = LayoutInflater.from(context);

    }
}
