package ro.pub.cs.systems.eim.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    EditText secondEditText;
    Button registerButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        secondEditText = findViewById(R.id.secondEditText);
        registerButton = findViewById(R.id.registerButton);
        cancelButton = findViewById(R.id.cancelButton);

        secondEditText.setText(getIntent().getStringExtra("MESAJ"));

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, resultIntent);
                finish();
            }
        });
    }
}
