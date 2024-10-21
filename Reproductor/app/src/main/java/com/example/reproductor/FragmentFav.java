package com.example.reproductor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFav# newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFav extends Fragment {

ListView lvFavoritos;
ArrayList<String> favoritosList;

private static final String ARG_FAVORITOS = "favoritos";

    public FragmentFav() {
        // Required empty public constructor
    }

    public static FragmentFav newInstance(ArrayList<String> favoritos){
        FragmentFav fragment = new FragmentFav();
        Bundle args = new Bundle();
        args.putStringArrayList("FAVORITOS_LIST", favoritos);  // Pasamos la lista a través de un Bundle
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            favoritosList = getArguments().getStringArrayList(ARG_FAVORITOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);

        lvFavoritos = view.findViewById(R.id.lvFavoritos);

        if(getArguments() != null){
            favoritosList = getArguments().getStringArrayList("FAVORITOS_LIST");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_list_item_1, favoritosList != null ? favoritosList : new ArrayList<>()
        );
        lvFavoritos.setAdapter(adapter);
        return view;
    }
}