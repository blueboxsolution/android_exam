package com.bbx.androidexam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bbx.androidexam.R;
import com.bbx.androidexam.adapters.PersonListViewAdapter;
import com.bbx.androidexam.common.API;
import com.bbx.androidexam.common.AndroidExamAsyncTask;
import com.bbx.androidexam.common.AsyncTaskListener;
import com.bbx.androidexam.common.InternalStorage;
import com.bbx.androidexam.models.PersonList;
import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;

/**
 * Created by macbookair on 27/09/2017.
 */

public class PersonListFragment extends Fragment implements AsyncTaskListener{

    private PersonList personList;
    private ListView listView;
    private PersonListViewAdapter personListViewAdapter;
    InternalStorage internalStorage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        listView = (ListView) view.findViewById(R.id.listview);

        internalStorage = new InternalStorage();

        if(!internalStorage.isFileExist(getActivity(), "PersonList")){
            getListAsyncTask();
        }else{
            try {
                String personListStr = internalStorage.readObject(getActivity(),"PersonList");
                personList =  LoganSquare.parse(personListStr, PersonList.class);
                populateView();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public void onTaskComplete(String result) {
        if(result != null){
            try {
                personList =  LoganSquare.parse(result, PersonList.class);
                internalStorage.writeObject(getActivity(), "PersonList", result);
                populateView();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getListAsyncTask(){
        new AndroidExamAsyncTask(API.RAW_JSON, this).execute();
    }

    private void populateView(){

        personListViewAdapter = new PersonListViewAdapter(getActivity(), personList);
        listView.setAdapter(personListViewAdapter);
        personListViewAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new OnItemClickListener());
    }

    class OnItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Bundle bundle = new Bundle();
            bundle.putSerializable("personInfo", personList.person.get(position));

            PersonInfoFragment personInfoFragment = new PersonInfoFragment();
            personInfoFragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.placeholder, personInfoFragment);
            transaction.addToBackStack(null);
            transaction.commit();


        }
    }

}
