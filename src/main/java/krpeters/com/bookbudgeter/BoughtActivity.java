package krpeters.com.bookbudgeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BoughtActivity extends AppCompatActivity {
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought);

        addButton = (Button) findViewById(R.id.button5);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyBook();
                Intent intent = new Intent(BoughtActivity.this, MainActivity.class);
                intent.putExtra("message", "You have read \n"  + PagesSingleton.getInstance().getTotalPages() + " pages!" + "\n You have earned \n" + "$" + PagesSingleton.getInstance().getTotalBalance());
                startActivity(intent);
            }
        });
    }

    public void buyBook() {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        PagesSingleton.getInstance().buyBook(Double.parseDouble(message));
    }
}
