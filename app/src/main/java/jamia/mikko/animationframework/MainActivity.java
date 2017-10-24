package jamia.mikko.animationframework;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, yesButton;
    private Animation slideInLeft, bounce;
    private ArrayList<Button> buttonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slideinleft);
        bounce = AnimationUtils.loadAnimation(this, R.anim.shake);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        yesButton = (Button) findViewById(R.id.yesButton);


        buttonArray = new ArrayList<>();

        buttonArray.add(button1);
        buttonArray.add(button2);
        buttonArray.add(button3);
        Handler handler = new Handler();

        for(int i = 0; i < buttonArray.size(); i++) {
            final int buttonIndex = i;

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    buttonArray.get(buttonIndex).startAnimation(slideInLeft);
                    buttonArray.get(buttonIndex).setVisibility(View.VISIBLE);
                }
            }, 1000 * i);
        }

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesButton.startAnimation(bounce);
            }
        });
    }
}
