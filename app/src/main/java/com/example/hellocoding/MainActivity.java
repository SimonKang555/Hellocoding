package com.example.hellocoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

    public void abc() {
    }

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
        Button newPageButton = findViewById(R.id.new_page_button);
        newPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondPageActivity.class);
                startActivity(intent);
            }
        });
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
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Person person1 = new Person();
        person1.grade = "7th";
        person1.name = "Simon K";
        person1.hairColor = "Black";
        person1.food = "Pasta";
        person1.foodImage = R.drawable.pasta;

        Person person2 = new Person();
        person2.grade = "7th";
        person2.name = "Daniel K";
        person2.hairColor = "Red";
        person2.food = "Pizza";
        person2.foodImage = R.drawable.pizza;

        Person person3 = new Person();
        person3.grade ="7th";
        person3.name = "Ian B";
        person3.hairColor = "Brown";
        person3.food = "Burgers";
        person3.foodImage = R.drawable.burger;

        Person person4 = new Person();
        person4.grade = "7th";
        person4.name = "Kristian H";
        person4.hairColor = "Blonde";
        person4.food = "Eggrolls";
        person4.foodImage = R.drawable.eggroll;


        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        recyclerViewAdapter.updateData(list);
    }
}
