package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1.Patient;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CustomAdapter extends ListAdapter<Patient, PatientViewHolder> {

    public CustomAdapter(@NonNull DiffUtil.ItemCallback<Patient> diffCallback) {
        super(diffCallback);
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PatientViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        Patient current = getItem(position);
        holder.bind(current.getInfo());
    }

    static class PatientDiff extends DiffUtil.ItemCallback<Patient> {

        @Override
        public boolean areItemsTheSame(@NonNull Patient oldItem, @NonNull Patient newItem) {
            Log.i("areItemsTheSame", "areItemsTheSame");
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Patient oldItem, @NonNull Patient newItem) {
            if (oldItem.getPatientID() == (newItem.getPatientID()))
            {
                Log.i("areContentsTheSame", "true");
                return true;
            }
            else
            {
                Log.i("areContentsTheSame", "false");
                return false;
            }
        }
    }
}
