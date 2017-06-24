package com.example.user.newmms.views;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.newmms.R;
import com.example.user.newmms.model.Simulation;

import java.util.Calendar;
import java.util.List;

public class SimulationsAdapter extends ArrayAdapter<Simulation> {
    public SimulationsAdapter(Context context, List<Simulation> simulations) {
        super(context, 0, simulations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Simulation simulation = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.simulation_item, parent, false);
        }
        // Lookup view for data population
        TextView simulationId = (TextView) convertView.findViewById(R.id.simulation_id);
        TextView reportNode = (TextView) convertView.findViewById(R.id.report_node);
        TextView reportTime = (TextView) convertView.findViewById(R.id.report_time);
        TextView simulationStatus = (TextView) convertView.findViewById(R.id.simulation_status);

        // Populate the data into the template view using the data object
        simulationId.setText(simulation.getId());
        reportNode.setText(simulation.getLastReport().getName());
        reportTime.setText(String.valueOf(simulation.getLastReport().getTime()));

        if (simulation.getLastReport().getName().equals(simulation.getPath().get(simulation.getPath().size()-1).getName())) {
            simulationStatus.setText("DELIVERED");
            simulationStatus.setTextColor(this.getContext().getResources().getColor(android.R.color.holo_green_light));
        }
        else {
            simulationStatus.setText("will arrive on " + simulation.getDeliveryTime());
            simulationStatus.setTextColor(this.getContext().getResources().getColor(android.R.color.black));
        }
        // Return the completed view to render on screen
        return convertView;
    }
}
