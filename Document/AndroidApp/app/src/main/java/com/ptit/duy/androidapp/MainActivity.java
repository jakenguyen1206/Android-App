package com.ptit.duy.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ptit.duy.androidapp.adapter.PersonAdapter;
import com.ptit.duy.androidapp.app2.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etHoTen;
    private EditText etDiaChi;
    private ListView lvDanhSach;
    private RadioButton rdBinhThuong;
    private RadioButton rdKhuyetTat;
    private Button bThem;
    private Button bThoat;

    private ArrayList<Person> data = new ArrayList<>();

    PersonAdapter adapter;

    private void setControl() {
        etHoTen = (EditText) findViewById(R.id.etHoTen); //Tìm ID của đối tượng
        etDiaChi = (EditText) findViewById(R.id.etDiaChi);
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach);
        rdBinhThuong = (RadioButton) findViewById(R.id.rdBinhThuong);
        rdKhuyetTat = (RadioButton) findViewById(R.id.rdKhuyetTat);
        bThem = (Button) findViewById(R.id.bThem);
        bThoat = (Button) findViewById(R.id.bThoat);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();

        //final ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_dropdown_item_1line, data);
        //final khai báo biến toàn cục

        adapter = new PersonAdapter(this, R.layout.layout2, data);

        lvDanhSach.setAdapter(adapter); //Chuyển đổi Class Person thành ListView

        //Toast.makeText(this, "MODAFUKA",Toast.LENGTH_SHORT).show();

        bThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--------XUẤT THÔNG BÁO TRÊN APP-----------
                //Toast.makeText(this, "MODAFUKA",Toast.LENGTH_SHORT).show(); //Hàm sẽ không hiểu this của phương thức nàp
                Toast.makeText(getApplicationContext(), "MODAFUKA", Toast.LENGTH_SHORT).show(); //Hàm hiện thông báo
                Log.d("TEST", etHoTen.getText().toString());    //Log Debug - tương tự như system.out.print. Xem ở Android Monitor (ver < 3.0) - Logcat (ver >= 3.0)
                Log.d("TEST", etDiaChi.getText().toString());
                if (rdBinhThuong.isChecked()) {
                    Log.d("TEST", rdBinhThuong.getText().toString());
                } else {
                    Log.d("TEST", rdKhuyetTat.getText().toString());
                }

                //-------GÁN VÀO CLASS PERSON----------------
                Person person = new Person();
                person.setHoTen(etHoTen.getText().toString());
                person.setDiaChi(etDiaChi.getText().toString());
                if (rdBinhThuong.isChecked()) {
                    person.setTinhTrang(rdBinhThuong.getText().toString());
                } else {
                    person.setTinhTrang(rdKhuyetTat.getText().toString());
                }
                //Test x
                Toast.makeText(getApplicationContext(), person.toString(), Toast.LENGTH_SHORT).show();

                data.add(person);   //Thêm đối tượng vào ArrayList
                adapter.notifyDataSetChanged(); //Thêm đối tượng vào ListView
            }

        });

        bThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

