package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private Button northButton, eastButton, westButton, southButton, secondButton;
    private EditText editText;
    private int pressedButtons = 0;

    private MyBroadCastReceiver receiver;
    private IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("PRESSED")) {
                pressedButtons = savedInstanceState.getInt("PRESSED");
            }
        }

        Log.d("ON_CREATE", String.valueOf(pressedButtons));

        northButton = findViewById(R.id.northButton);
        eastButton = findViewById(R.id.eastButton);
        westButton = findViewById(R.id.westButton);
        southButton = findViewById(R.id.southButton);
        secondButton = findViewById(R.id.secondButton);
        editText = findViewById(R.id.editText);

        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "NORTH,");
                pressedButtons ++;
                if (pressedButtons == 4) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01Service.class);
                    startService(intent);

                    Log.d("MESAJ_BROADCAST", "started service");

                    receiver = new MyBroadCastReceiver();
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("MESAJ_BROADCAST");
                    registerReceiver(receiver, intentFilter);
                }
            }
        });

        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "WEST,");
                pressedButtons ++;
                if (pressedButtons == 4) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01Service.class);
                    startService(intent);

                    Log.d("MESAJ_BROADCAST", "started service");

                    receiver = new MyBroadCastReceiver();
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("MESAJ_BROADCAST");
                    registerReceiver(receiver, intentFilter);
                }
            }
        });

        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "EAST,");
                pressedButtons ++;
                if (pressedButtons == 4) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01Service.class);
                    startService(intent);

                    Log.d("MESAJ_BROADCAST", "started service");

                    receiver = new MyBroadCastReceiver();
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("MESAJ_BROADCAST");
                    registerReceiver(receiver, intentFilter);
                }
            }
        });

        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "SOUTH,");
                pressedButtons ++;
                if (pressedButtons == 4) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01Service.class);
                    startService(intent);

                    Log.d("MESAJ_BROADCAST", "started service");

                    receiver = new MyBroadCastReceiver();
                    intentFilter = new IntentFilter();
                    intentFilter.addAction("MESAJ_BROADCAST");
                    registerReceiver(receiver, intentFilter);
                }
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                Log.d("MESAJ", editText.getText().toString());
                intent.putExtra("MESAJ", editText.getText().toString());
                pressedButtons = 0;
                editText.setText("");
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("PRESSED", pressedButtons);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("PRESSED")) {
                pressedButtons = savedInstanceState.getInt("PRESSED");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(), resultCode == RESULT_OK ? "REGISTER" : "CANCEL", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (receiver != null) {
            registerReceiver(receiver, intentFilter);
        }
    }

    @Override
    protected void onPause() {
        if (receiver != null) {
            unregisterReceiver(receiver);
        }

        super.onPause();
    }
}
