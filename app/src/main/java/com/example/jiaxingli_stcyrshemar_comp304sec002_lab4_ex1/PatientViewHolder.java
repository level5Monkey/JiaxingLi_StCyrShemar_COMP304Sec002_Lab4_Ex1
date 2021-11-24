package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

class PatientViewHolder extends RecyclerView.ViewHolder{
    private final TextView textViewPatientInfo;

    private PatientViewHolder(View itemView) {
        super(itemView);
        textViewPatientInfo = itemView.findViewById(R.id.textViewPatientInfo);
    }

    public void bind(String patient) {
        textViewPatientInfo.setText(patient);
    }

    static PatientViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_patients, parent, false);
        return new PatientViewHolder(view);
    }
}


