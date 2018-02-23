package com.example.jakub435.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;


import java.util.ArrayList;

/**
 * Created by Jakub435 on 2018-02-12.
 */

public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;



    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        // TODO: Taking data from database and put it into PageFragment
        ExpLVAdapter ExpAdapter;
        ArrayList<Group> ExpListItems;
        ExpandableListView ExpandList;

        ExpandList = view.findViewById(R.id.myDietListView);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpLVAdapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


        return view;
    }

    //----------------------------------------------------

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Śniadanie: Jajecznica z gówienkiem","II Śniadanie", "Obiad", "Podwieczorek","Kolacja"};

        String[] Ingredient ={"skladnik 1 \nskladnik2 \nskladnik3 \nskladnik4","jab","kog","osd","asd",};
        String[] Description = {"Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis Opis ","soooooooooooooome sooooooooooooom soooooooooom Lro","soooooooooooooome sooooooooooooom soooooooooom Lro","soooooooooooooome sooooooooooooom soooooooooom Lro","soooooooooooooome sooooooooooooom soooooooooom Lro"};
        String[] Nutrient = {"100kcal B10 T20 W30 koszt 3.50","100kcal","100kcal","100kcal","100kcal"};
        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setDescription(Description[j]);
                ch.setIngredient(Ingredient[j]);
                ch.setNutrition(Nutrient[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }

}
