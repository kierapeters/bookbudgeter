package krpeters.com.bookbudgeter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {
    private PagesSingleton pagesSingleton;
    private MainActivity mainActivity;
    private Button logPagesButton;
    // need to create only one instance of pages?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        if (PagesSingleton.getInstance() == null) {
            pagesSingleton = new PagesSingleton();
        }
        else {
            pagesSingleton = PagesSingleton.getInstance();
        }
        logPagesButton = (Button) findViewById(R.id.button3);
        logPagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence message = logPages();
                Toast toast = Toast.makeText(getApplicationContext(), message + " pages read", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(LogActivity.this, MainActivity.class);
                intent.putExtra("message", "You have read \n"  + PagesSingleton.getInstance().getTotalPages() + " pages!" + "\n You have earned \n" + "$" + PagesSingleton.getInstance().getTotalBalance());
                startActivity(intent);
            }
        });
    }

    public String logPages() {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        PagesSingleton.getInstance().addPages(Integer.parseInt(message));
        return message;
        //pagesSingleton.addPages(Integer.parseInt(message));
    }

}




