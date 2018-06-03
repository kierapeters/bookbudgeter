package krpeters.com.bookbudgeter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    private EditText amountTextView;
    private Button amountButton;
    private PagesSingleton pagesSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if (PagesSingleton.getInstance() == null) {
            pagesSingleton = new PagesSingleton();
        }
        else {
            pagesSingleton = PagesSingleton.getInstance();
        }

        amountTextView = (EditText) findViewById(R.id.textView5);
        Double AMOUNT_PER_PAGE = pagesSingleton.getAmountPerPage();
        amountTextView.setText(AMOUNT_PER_PAGE.toString());

        amountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                amountTextView = (EditText) findViewById(R.id.textView5);
//                Double amnt = Double.parseDouble(amountTextView.getText().toString());
//                pagesSingleton.setAmountPerPage(amnt);
            }
        });

        amountButton = (Button) findViewById(R.id.button6);
        amountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountTextView = (EditText) findViewById(R.id.textView5);
                Double amnt = Double.parseDouble(amountTextView.getText().toString());
                pagesSingleton.setAmountPerPage(amnt);

            }
        });
    }
}
