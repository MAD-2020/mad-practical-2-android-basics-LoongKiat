package sg.edu.np.mad.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="";
    private Button middle_button;
    private Button right_button;
    private Button left_button;
    private String mole;
    private Button target;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left_button = findViewById(R.id.zero);
        middle_button = findViewById(R.id.one);
        right_button = findViewById(R.id.two);

        left_button.setOnClickListener(buttonOnClickListener);
        middle_button.setOnClickListener(buttonOnClickListener);
        right_button.setOnClickListener(buttonOnClickListener);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        switch (randomLocation){
            case 0:{
                mole = "zero";
                break;
            }
            case 1:{
                mole = "one";
                break;
            }
            default:{
                mole = "two";
                break;
            }
        }
        switch (mole){
            case "zero":{
                left_button.setText("*");
                middle_button.setText("O");
                right_button.setText("O");
                break;
            }
            case "one":{
                left_button.setText("O");
                middle_button.setText("*");
                right_button.setText("O");
                break;
            }
            default:{
                left_button.setText("O");
                middle_button.setText("O");
                right_button.setText("*");
                break;
            }
        }
    }

    private View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = (TextView) findViewById(R.id.textView);
            switch (v.getId()){
                case R.id.zero:{
                    if (left_button.getText() == "*" ){
                        score += 1;
                    }
                    else {
                        score -= 1;
                    }
                    textView.setText("Score is: " + score);
                    setNewMole();
                    break;
                }
                case R.id.one:{
                    if (middle_button.getText() == "*"){
                        score += 1;
                    }
                    else{
                        score -= 1;
                    }
                    textView.setText("Score is: " + score);
                    setNewMole();
                    break;
                }
                default:{
                    if (right_button.getText() == "*"){
                        score += 1;
                    }
                    else{
                        score -= 1;
                    }
                    textView.setText("Score is: " + score);
                    setNewMole();
                    break;
                }
            }
        }
    };
}
