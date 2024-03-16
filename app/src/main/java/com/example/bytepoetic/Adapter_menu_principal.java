package com.example.bytepoetic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_menu_principal extends RecyclerView.Adapter<Adapter_menu_principal.viewHolderMenu> implements View.OnClickListener {

    ArrayList<menuPrincipal> listaMenu;

    public Adapter_menu_principal(ArrayList<menuPrincipal> listaMenu) {
        this.listaMenu = listaMenu;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public Adapter_menu_principal.viewHolderMenu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_proyecto,null,false);

        return new viewHolderMenu(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_menu_principal.viewHolderMenu holder, int position) {
        holder.titulo.setText(String.valueOf(listaMenu.get(position).getTitulo()));

    }

    @Override
    public int getItemCount() {
        return listaMenu.size();
    }

    public class viewHolderMenu extends RecyclerView.ViewHolder {
        TextView titulo;
        public viewHolderMenu(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.titulo);
        }
    }
}
