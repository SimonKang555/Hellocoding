package com.example.hellocoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewAdapter = new RecyclerViewAdapter();
        EditText nameEditText = findViewById(R.id.editTextTextPersonName);
        EditText gradeEditText = findViewById(R.id.editTextTextPersonGrade);
        Button gradeButton = findViewById(R.id.gradeButton);
        TextView resultTextView = findViewById(R.id.resultTextView);
        Button nameButton = findViewById(R.id.nameButton);
        Button nameAndGradeButton = findViewById(R.id.nameAndGradeButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();

                if (name.equals("Simon")) {
                    resultTextView.setText("Simon is cool");
                } else if (name.equals("Min")) {
                    resultTextView.setText("Min is awesome");
                } else {
                    resultTextView.setText(name);
                }
            }
        });

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = nameEditText.getText().toString();

                if (name.length() > 2) {
                    nameButton.setEnabled(true);
                } else {
                    nameButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        gradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = gradeEditText.getText().toString();
                resultTextView.setText(grade);
            }
        });

        nameAndGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String grade = gradeEditText.getText().toString();
                String nameAndGrade = name + " is in " + grade + " grade";
                resultTextView.setText(nameAndGrade);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Person> list = new ArrayList<>();
        list.add(new Person("Simon K", "7th"));
        list.add(new Person("Daniel K", "7th"));
        list.add(new Person("Ian B", "7th"));
        list.add(new Person("Kristian H", "7th"));
        list.add(new Person("George C", "7th"));
        list.add(new Person("Simon K", "7th"));
        list.add(new Person("Daniel K", "7th"));
        list.add(new Person("Ian B", "7th"));
        list.add(new Person("Kristian H", "7th"));
        list.add(new Person("George C", "7th"));
        list.add(new Person("Simon K", "7th"));
        list.add(new Person("Daniel K", "7th"));
        list.add(new Person("Ian B", "7th"));
        list.add(new Person("Kristian H", "7th"));
        list.add(new Person("George C", "7th"));
        list.add(new Person("Simon K", "7th"));
        list.add(new Person("Daniel K", "7th"));
        list.add(new Person("Ian B", "7th"));
        list.add(new Person("Kristian H", "7th"));
        list.add(new Person("George C", "7th"));
        list.add(new Person("Simon K", "7th"));
        list.add(new Person("Daniel K", "7th"));
        list.add(new Person("Ian B", "7th"));
        list.add(new Person("Kristian H", "7th"));
        list.add(new Person("George C", "7th"));

        recyclerViewAdapter.updateData(list);
    }
}
