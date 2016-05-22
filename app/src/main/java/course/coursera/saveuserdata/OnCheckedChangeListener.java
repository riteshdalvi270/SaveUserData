package course.coursera.saveuserdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by ritesh on 5/22/16.
 */
public class OnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

    final RadioButton onFocusRadioButton;
    final RadioButton radioButton1;
    final RadioButton radioButton2;
    final RelativeLayout relativeLayout;
    final Context context;
    final SharedPreferences sharedPreferences;
    final int color;

    public OnCheckedChangeListener(final Context context, final int color, final RelativeLayout layout, final SharedPreferences sharedPreferences, final RadioButton onFocusRadioButton, final RadioButton radioButton1, final RadioButton radioButton2) {

        this.onFocusRadioButton = onFocusRadioButton;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
        this.relativeLayout = layout;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.color = color;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked) {
            final SharedPreferences.Editor editer = sharedPreferences.edit();
            editer.putLong("color", color);
            editer.commit();

            relativeLayout.setBackgroundColor((int) sharedPreferences.getLong("color", 0L));

            radioButton1.setChecked(false);
            radioButton2.setChecked(false);


            if(onFocusRadioButton.hasSelection()) {
                onFocusRadioButton.setChecked(false);
            }

            Toast.makeText(context, "SAVED", Toast.LENGTH_SHORT).show();
        }
    }
}
