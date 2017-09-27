package com.bbx.androidexam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bbx.androidexam.R;
import com.bbx.androidexam.common.Util;
import com.bbx.androidexam.models.Person;

/**
 * Created by macbookair on 27/09/2017.
 */

public class PersonInfoFragment extends Fragment {

    private Person person;
    Util util;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_person_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        util = new Util(getActivity());

        Bundle bundle = getArguments();
        person = (Person) bundle.getSerializable("personInfo");

        TextView textViewFirstname, textViewLastname, textViewBirthday, textViewAge, textViewEmailladd, textViewMobileno,
                textViewAddress, textViewContactperson, textViewConpersonno;

        textViewFirstname = view.findViewById(R.id.first_name);
        textViewLastname = view.findViewById(R.id.last_name);
        textViewBirthday = view.findViewById(R.id.birthday);
        textViewAge = view.findViewById(R.id.age);
        textViewEmailladd = view.findViewById(R.id.email_add);
        textViewMobileno = view.findViewById(R.id.mobile_no);
        textViewAddress = view.findViewById(R.id.address);
        textViewContactperson = view.findViewById(R.id.con_person);
        textViewConpersonno = view.findViewById(R.id.con_person_no);

        textViewFirstname.setText(person.getFirstname());
        textViewLastname.setText(person.getLastname());
        textViewBirthday.setText(person.getBirthdate());
        textViewAge.setText(util.computeAge(person.getBirthdate()));
        textViewEmailladd.setText(person.getEmail());
        textViewMobileno.setText(person.getMobile());
        textViewAddress.setText(person.getAddress());
        textViewContactperson.setText(person.getContactperson());
        textViewConpersonno.setText(person.getContactpnumber());

    }
}
