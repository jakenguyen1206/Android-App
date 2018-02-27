package com.ptit.duy.androidapp.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ptit.duy.androidapp.R;
import com.ptit.duy.androidapp.app2.Person;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Duy on 26/02/2018.
 */

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;
    private ArrayList<Person> objects;

    //Sau khi tạo Constructor đổi @NonNull List thành @NonNull ArrayList
    public PersonAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context); //Lấy từ đối tượng context
        convertView = inflater.inflate(resource,parent,false);  //Gán vào resource

        TextView tvHoten;
        TextView tvDiachi;

        Person p = objects.get(position);
        tvHoten = (TextView) convertView.findViewById(R.id.tvHoTen);
        tvDiachi = (TextView) convertView.findViewById(R.id.tvDiaChi);

        tvHoten.setText(p.getHoTen());
        tvDiachi.setText(p.getDiaChi());

        return convertView;
    }
}
