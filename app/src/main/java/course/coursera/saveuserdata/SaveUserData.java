package course.coursera.saveuserdata;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SaveUserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_user_data);

        final String myPreferences = "myPref";

        final SharedPreferences sharedPreferences = getSharedPreferences(myPreferences, MODE_PRIVATE);

        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);

        final long color = sharedPreferences.getLong("color", 0L);

        if(color != 0) {
            layout.setBackgroundColor((int) sharedPreferences.getLong("color", 0L));
        }


        final RadioButton blue = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton green = (RadioButton)findViewById(R.id.radioButton2);
        final RadioButton red = (RadioButton)findViewById(R.id.radioButton3);

        blue.setOnCheckedChangeListener(new OnCheckedChangeListener(getApplicationContext(),Color.BLUE,layout,sharedPreferences,blue,green,red));

        green.setOnCheckedChangeListener(new OnCheckedChangeListener(getApplicationContext(),Color.GREEN,layout,sharedPreferences,green,blue,red));

        red.setOnCheckedChangeListener(new OnCheckedChangeListener(getApplicationContext(),Color.RED,layout,sharedPreferences,red,green,blue));
    }
}
