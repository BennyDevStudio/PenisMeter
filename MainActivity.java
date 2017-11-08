package com.example.beni.pm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import static java.lang.Math.toIntExact;

public class MainActivity extends AppCompatActivity {

    String nevEllenor;
    String nevv;
    public void calculate (View view){

        Button button= findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        ImageView penis= findViewById(R.id.imageView);
        ImageView ruler= findViewById(R.id.imageView4);
        ImageView meter= findViewById(R.id.meter);
        ImageView setmeter= findViewById(R.id.setmeter) ;
        LinearLayout linearLayout= findViewById(R.id.linearLayout);
        LinearLayout linearLayout2= findViewById(R.id.linearLayout2);
        TextView view1= findViewById(R.id.textView2);
        EditText Tnev = findViewById(R.id.nev);
        EditText Tkor= findViewById(R.id.kor);
        TextView textViewHossz= findViewById(R.id.textViewHossz);


        double nev= (double)Tnev.getText().toString().length();
        nevv= Tnev.getText().toString();
        if(nevv!=nevEllenor){
            nev=nev/7;
            int kor= Integer.parseInt(Tkor.getText().toString())/10;
           // Toast.makeText(MainActivity.this, "Hossdddz:"+ Double.toString(nev),Toast.LENGTH_SHORT).show();
            Random r = new Random();
            if(nev*7>10 || kor>21) {
                Toast.makeText(MainActivity.this, "Hazug geci, félsz hogy pici a farkad?(valós adatokat adja meg)", Toast.LENGTH_SHORT).show();
            }
            else {
                int rSzel = r.nextInt(80 - 65) + 65;
                double rHossz = 0;
                do {
                    rHossz = r.nextDouble();
                } while (rHossz < 0.1);
                rHossz = rHossz * nev * kor;
                if (rHossz < 5) {
                    rHossz = rHossz + 7;
                    rHossz = r.nextDouble() + 1;
                }
                if (rHossz < 8) {
                    rHossz = rHossz + r.nextInt(9) + 1;
                }
                if (rHossz > 24) {
                    rHossz = rHossz - 3;
                }
                String Hossz = Double.toString(rHossz);
                // Toast.makeText(MainActivity.this, "Hossz:" + String.format("%.2f", rHossz), Toast.LENGTH_SHORT).show();

                int height = Math.toIntExact(Math.round(rHossz * 30 * 1.5));
                // Toast.makeText(MainActivity.this, "Hossz:"+ Integer.toString(height),Toast.LENGTH_SHORT).show();
                textViewHossz.setText(String.format("%.2f", rHossz) + "cm");
                ViewGroup.LayoutParams params = penis.getLayoutParams();
                params.height = height;
                penis.setImageResource(R.drawable.pen);
                if (rHossz > 18) {
                    penis.setImageResource(R.drawable.penb);
                }
                if (rHossz < 8) {
                    penis.setImageResource(R.drawable.pens);
                }
                penis.setVisibility(View.VISIBLE);
                ruler.setVisibility(View.VISIBLE);
                meter.setVisibility(View.VISIBLE);
                setmeter.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);


                view1.setVisibility(View.INVISIBLE);
                linearLayout2.animate().alpha(1).setDuration(300);
                penis.setLayoutParams(params);
                nevEllenor = nevv;
            }
        }
        if(nevv==nevEllenor){
            Toast.makeText(MainActivity.this, ")", Toast.LENGTH_SHORT).show();
        }
    }
    public void newCalculate(View view){
        TextView view1= findViewById(R.id.textView2);
        LinearLayout linearLayout= findViewById(R.id.linearLayout);
        LinearLayout linearLayout2= findViewById(R.id.linearLayout2);
        ImageView penis= findViewById(R.id.imageView);
        ImageView ruler= findViewById(R.id.imageView4);
        Button button= findViewById(R.id.button);
        ImageView meter= findViewById(R.id.meter);
        ImageView setmeter= findViewById(R.id.setmeter) ;

        button.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout2.animate().alpha(0);
        penis.setVisibility(View.INVISIBLE);
        ruler.setVisibility(View.INVISIBLE);
        view1.setVisibility(View.VISIBLE);
        meter.setVisibility(View.INVISIBLE);
        setmeter.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView meter= findViewById(R.id.meter);
        ImageView setmeter= findViewById(R.id.setmeter);

        meter.setVisibility(View.INVISIBLE);
        setmeter.setVisibility(View.INVISIBLE);
    }
}
