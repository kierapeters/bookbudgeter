package krpeters.com.bookbudgeter;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button logButton;
    private Button boughtButton;
    private TextView textView;
    private PagesSingleton pagesSingleton;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (PagesSingleton.getInstance() == null) {
            pagesSingleton = new PagesSingleton();
        }
        else {
            pagesSingleton = PagesSingleton.getInstance();
        }
        textView = (TextView) findViewById(R.id.textView2);

        if (getIntent().getStringExtra("message") != null) {
            textView.setText(getIntent().getStringExtra("message"));
        } else {
            textView.setText("You have read \n 0 pages! \n You have earned \n $0.00!");
        }

        logButton = (Button) findViewById(R.id.button);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logActivity = new Intent(getApplicationContext(), LogActivity.class);
                startActivity(logActivity);
            }
        });

        boughtButton = (Button) findViewById(R.id.button2);
        boughtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent boughtActivity = new Intent(getApplicationContext(), BoughtActivity.class);
                startActivity(boughtActivity);
            }
        });

        settingsButton = (Button) findViewById(R.id.button4);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsActivity = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settingsActivity);
            }
        });

    }






}
