package com.bbx.androidexam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bbx.androidexam.R;
import com.bbx.androidexam.models.PersonList;

/**
 * Created by macbookair on 27/09/2017.
 */

public class PersonListViewAdapter extends BaseAdapter {

    PersonList personList;
    private LayoutInflater mInflater;

    public PersonListViewAdapter(Context context, PersonList personList) {
        this.personList = personList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return this.personList.person.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.row_person_list, null);
        TextView personName = (TextView) view.findViewById(R.id.personName);
        personName.setText(personList.person.get(i).getFirstname() + " " + personList.person.get(i).getLastname());
        return view;
    }
}
