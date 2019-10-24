package com.example.lienardr_projet.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lienardr_projet.R;
import com.example.lienardr_projet.db.User;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context context, List<User> userList) {
        super(context, R.layout.template_user, userList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView tvprenom = (TextView) rowView.findViewById(R.id.user_template_prenom);
        TextView tvnom = (TextView) rowView.findViewById(R.id.user_template_nom);

        //
        tvnom.setText(user.getNom());
        tvprenom.setText(user.getPrenom());

        //
        return rowView;
    }
}
