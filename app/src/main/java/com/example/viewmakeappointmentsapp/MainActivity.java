package com.example.viewmakeappointmentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //تعريف  من ل viwe obj
        EditText name = findViewById(R.id.et_name);
        RadioButton male =findViewById(R.id.rbtn_male);
        RadioButton female =findViewById(R.id.rbtn_female);
        EditText phone = findViewById(R.id.et_num_phone);
        EditText BofD = findViewById(R.id.et_bd);
        Spinner place = findViewById(R.id.spin_place);
        EditText date_res= findViewById(R.id.et_date_reservation);
        EditText hours = findViewById(R.id.et_hours);
        Spinner medical = findViewById(R.id.spin_medical);
        Button confirm = findViewById(R.id.btn_confirm);
        Button clear = findViewById(R.id.btn_clear);
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);


        //نوع البيانات المدخلة لا يوجد
        //لكي نستطيع عرض التقويم في edit text

        BofD.setInputType(InputType.TYPE_NULL);
        //عند الضغط على مكان ادخال تاريخ الميلاد يجب ان يظهر  تقويم

        BofD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Title = BofD.getHint().toString();

                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                            {
                                BofD.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.setTitle(Title);
                picker.show();
            }
        });


        date_res.setInputType(InputType.TYPE_NULL);
        //عند الضغط على مكان ادخال تاريخ الحجز يجب ان يظهر  تقويم

        date_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = date_res.getHint().toString();
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                            {
                                date_res.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.setTitle(Title);
                picker.show();
            }
        });


        hours.setInputType(InputType.TYPE_NULL);
        //عند الضغط على مكان ادخال الموعد يجب ان يظهر  الساعة

        hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour= cldr.get(Calendar.HOUR_OF_DAY);
                int minute = cldr.get(Calendar.MINUTE);
                String Title = hours.getHint().toString();

                // date picker dialog
                TimePickerDialog picker = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int m, int h) {
                                hours.setText(m + " : " + h);
                            }
                        }, hour, minute, false);
                picker.setTitle(Title);
                picker.show();
            }
        });



        //عند الضعط على الزر راح يقراء كل البيانات الي اختارها ودخلها المستخدم

        confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            //يتم استدعائها بمجرد الضغط على الزر
            public void onClick(View v)
            {
                //بقراء الاسم الثلاثي الي في اسم وابعته في رسالة
                String full_name =name.getText().toString();

                //قراءة الراديو بوتن من خلال الفحص الجنس
                //هل اختار ذكر او انثى وبعته في رسالة
                String gender = null;
                if(male.isChecked())
                    gender ="male";
                else
                    gender ="female";

                //بقراء رقم الجوال وابعته في رسالة
                String unm_phone =phone.getText().toString();

                //بقراء تاريخ الميلاد وابعته في رسالة
                String BD =BofD.getText().toString();

                //قراءة من لسبنر اختيار مكان السكن
                //لاعطاء القيمة المحددة وبعته في رسالة
                String choose_place = place.getSelectedItem().toString();

                //بقراء تاريخ الحجز وابعته في رسالة
                String reservation =date_res.getText().toString();

                //بقراء موعد الحجز وابعته في رسالة
                String hou =hours.getText().toString();

                //قراءة من لسبنر اختيارالعيادة
                //لاعطاء القيمة المحددة وبعته في رسالة
                String choose_medical = medical.getSelectedItem().toString();

                //متغير يحمل جملة تاكيد  الحجز
                String conf = clear.getText().toString();

                Toast.makeText(MainActivity.this,

                           conf + " ✔💯 " +"\n"+
                                full_name      + " " +
                                gender         + " " +
                                unm_phone      + " " +
                                BD             + " " +
                                choose_place   + " " +
                                choose_medical + " " +
                                reservation    + " " +
                                hou            + " "

                        ,Toast.LENGTH_LONG).show();

            }
        });


        //عند الضعط على الزر مسح الشاشة راح يمسح كل البيانات الي اختارها ودخلها المستخدم

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            //يتم استدعائها بمجرد الضغط على الزر
            public void onClick(View v)
            {
                //مسح الاسم الثلاثي
                name.setText("");

                //مسح الراديو بوتن الي اختاره المستخدم
                    male.setChecked(false);
                    female.setChecked(false);


                //مسح رقم الجوال
                phone.setText("");

                //مسح تاريخ الميلاد
                BofD.setText("");

                //مسح  لسبنر اختيار مكان السكن
                place.setSelected(false);

                //مسح تاريخ الحجز
                date_res.setText("");

                //مسح ساعة الحجز
                hours.setText("");

                //مسح من لسبنر اختيارالعيادة
                 medical.setSelected(false);


                 //متغير يحمل جملة تاكيد مسح الشاشة
                String del = clear.getText().toString();

                Toast.makeText(MainActivity.this,del + " ✔💯 ",Toast.LENGTH_LONG).show();

            }
        });





    }
}