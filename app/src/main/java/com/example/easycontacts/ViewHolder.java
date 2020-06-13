package com.example.easycontacts;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView show_name;
    private TextView show_contact;
    public ViewHolder(View v){
        super(v);
        show_name = v.findViewById(R.id.c1_name);
        show_contact = v.findViewById((R.id.c1_contact));
    }

    public TextView getShow_name() {
        return show_name;
    }

    public TextView getShow_contact() {
        return show_contact;
    }
}
