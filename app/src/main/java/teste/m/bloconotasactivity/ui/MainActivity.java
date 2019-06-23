package teste.m.bloconotasactivity.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import teste.m.bloconotasactivity.R;

public class MainActivity extends AppCompatActivity {

    Button vrBtnLogim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        vrBtnLogim = findViewById(R.id.buttonLogin);

      vrBtnLogim.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
              startActivity(intent);

          }
      });
    }
}
