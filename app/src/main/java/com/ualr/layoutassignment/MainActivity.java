package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.ualr.layoutassignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label
    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        MaterialButtonToggleGroup discount_btnGroup = findViewById(R.id.discountToggle_group);
        MaterialButton nodiscount_btn = findViewById(R.id.nodiscount_btn);
        MaterialButton discount_btn = findViewById(R.id.discount_btn);
        MaterialButton calculate_btn= findViewById(R.id.calc_btn);
        Integer discount_ID = discount_btn.getId();
        MaterialCheckBox prod1_checkbox = findViewById(R.id.product1_checkbox);
        MaterialCheckBox prod2_checkbox = findViewById(R.id.product2_checkbox);
        MaterialCheckBox prod3_checkbox = findViewById(R.id.product3_checkbox);
        MaterialCheckBox prod4_checkbox = findViewById(R.id.product4_checkbox);
        EditText numfield1 = findViewById(R.id.Input1);
        EditText numfield2 = findViewById(R.id.Input2);
        EditText numfield3 = findViewById(R.id.Input3);
        EditText numfield4 = findViewById(R.id.Input4);
        TextView totalnum = findViewById(R.id.total_number);


        calculate_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            double discount;
            double total = 0;
            boolean prod1checked = prod1_checkbox.isChecked();
            boolean prod2checked = prod2_checkbox.isChecked();
            boolean prod3checked = prod3_checkbox.isChecked();
            boolean prod4checked = prod4_checkbox.isChecked();

                if(discount_btnGroup.getCheckedButtonId()== discount_ID)
                discount = .5;
            else discount= 1;
            if(prod1checked)
                total = total + getValue(numfield1);
            if(prod2checked)
                    total = total + getValue(numfield2);
            if(prod3checked)
                    total = total + getValue(numfield3);
            if(prod4checked)
                    total = total + getValue(numfield4);
            total = total * discount;
            String finalresult = Double.toString(total);
            totalnum.setText(finalresult);



            }
        });

}

    public Double getValue(EditText edit){
        String numtext = edit.getText().toString();
        double num = new Double(numtext).intValue();
        return num;
    }
}

