package flush.example.androidresigterlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.registerandlogin.R;

public class Welcome2 extends AppCompatActivity {

    private Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);
        btn_logout  = findViewById(R.id.btn_logout2);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Welcome2.this,LoginActivity.class));
            }
        });
    }

}
