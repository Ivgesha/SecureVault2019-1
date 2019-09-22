package view.explorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.securevault19.securevault2019.MainActivity;
import com.securevault19.securevault2019.R;

import java.util.List;

public class PatternLockView_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_lockview);

        final PatternLockView patternLockView;

        patternLockView = findViewById(R.id.patternView);

        patternLockView.addPatternLockListener(new PatternLockViewListener() {

            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List progressPattern) {

            }

            @Override
            public void onComplete(List pattern) {
                Log.d(getClass().getName(), "Pattern complete: " +
                        PatternLockUtils.patternToString(patternLockView, pattern));
                if (PatternLockUtils.patternToString(patternLockView, pattern).equalsIgnoreCase("012")) {
                    patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
                    Toast.makeText(getApplicationContext(), "Welcome back, User_Name", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), CategoryList_Activity.class);
                    startActivity(intent);
                    finish();

            } else {
                patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
                Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onCleared () {

        }
    });

}
    }

