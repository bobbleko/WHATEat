package anunpongi.th.ac.rmutl.whateat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    private String nameString, surnameString, genderString,
            ageString, statureString;


    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        Gender Controller
        genderController();

//        Save Controller
        saveController();

//        Age Controller
        ageController();



    }   //Main Methon

    private void ageController() {
        String[] strings = new String[]{"0","1","2","3","4","5","6",};
        Spinner spinner = getView().findViewById(R.id.spnAge);


    }

    private void genderController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.radMale:
                        genderString = "0";
                        break;
                    case R.id.radFamale:
                        genderString = "1";
                        break;

                }

            }
        });
    }

    private void saveController() {
        Button button = getView().findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText surnameEditText = getView().findViewById(R.id.edtSurname);

                nameString = nameEditText.getText().toString().trim();
                surnameString = surnameEditText.getText().toString().trim();

                MyAlert myAlert = new MyAlert(getActivity());

                RadioButton maleRadioButton = getView().findViewById(R.id.radMale);
                RadioButton famaleRedioButton = getView().findViewById(R.id.radFamale);

//                Check Space
                if (nameString.isEmpty() || surnameString.isEmpty() )
                         {
//                    Have Space
                    myAlert.normalDialog("Have Space", "Please Fill Every Blank");

                } else if (!(maleRadioButton.isChecked() || famaleRedioButton.isChecked())) {
//                    Non Choose Gerder
                    myAlert.normalDialog("Non Gender","Please Choose Male or Famele");
                }


            } //onClick
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

}
