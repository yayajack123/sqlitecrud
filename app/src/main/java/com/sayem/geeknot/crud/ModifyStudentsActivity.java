package com.sayem.geeknot.crud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyStudentsActivity extends AppCompatActivity {
    private StudentsModel studentsModel;
    private EditText etname, etnim, etemail, etphone;
    private DatabaseHelperStudent databaseHelperStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_student);

        Intent intent = getIntent();
        studentsModel = (StudentsModel) intent.getSerializableExtra("students");

        databaseHelperStudent = new DatabaseHelperStudent(this);

        etname = (EditText) findViewById(R.id.etname);
        etnim = (EditText) findViewById(R.id.etcourse);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);
        Button btndelete = (Button) findViewById(R.id.btndelete);
        Button btnupdate = (Button) findViewById(R.id.btnupdate);

        etname.setText(studentsModel.getName());
        etnim.setText(studentsModel.getNim());
        etemail.setText(studentsModel.getEmail());
        etphone.setText(studentsModel.getPhone());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperStudent.updateStudent(studentsModel.getId(),etname.getText().toString(),etnim.getText().toString(),etemail.getText().toString(), etphone.getText().toString());
                Toast.makeText(ModifyStudentsActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyStudentsActivity.this,StudentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperStudent.deleteUSer(studentsModel.getId());
                Toast.makeText(ModifyStudentsActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyStudentsActivity.this,StudentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
