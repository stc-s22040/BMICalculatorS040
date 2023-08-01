package jp.suntech.s22040;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.btcalculation);
        button1.setOnClickListener(new ButtonClickListener());
        Button button2 = findViewById(R.id.btclear);
        button2.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            //年齢・身長・体重
            EditText input1 = findViewById(R.id.etage);
            EditText input2 = findViewById(R.id.etheight);
            EditText input3 = findViewById(R.id.etweight);

            //ボタンを押したとき表示
            TextView output1 = findViewById(R.id.tvOutput1);
            TextView output2 = findViewById(R.id.tvOutput2);
            TextView output3 = findViewById(R.id.tvOutput3);
            TextView output4 = findViewById(R.id.tvOutput4);
            TextView output5 = findViewById(R.id.tvOutput5);


            int id = view.getId();

            if (id == R.id.btcalculation) {
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String inputStr3 = input3.getText().toString();
                output1.setText("あなたの肥満度は");
                output3.setText("あなたの適正体重は");
                output5.setText("kg");

                //String型をFloat型に
                float age = Float.parseFloat(inputStr1);
                float height = Float.parseFloat(inputStr2);
                float weight = Float.parseFloat(inputStr3);
                float score;

                //計算・結果
                height /= 100;
                score = weight/(height*height);
                String BMI  = String.format("%.1f",height*height*22);
                output4.setText(BMI);

                //肥満度の判定
                if(score <18.5){
                    output2.setText("低体重");
                }
                else if (score < 25) {
                    output2.setText("普通体重");
                }
                else if (score < 30) {
                    output2.setText("肥満(1度)");
                }
                else if (score <35) {
                    output2.setText("肥満(2度)");
                }
                else if (score<40) {
                    output2.setText("肥満(3度)");
                }
                else {
                    output2.setText("肥満(4度)");
                }

                //年齢が16歳未満だった時
                if(age<16){
                    Dialog dialogFragment = new Dialog();
                    dialogFragment.show(getSupportFragmentManager(),"DialogFragment");
                }

            } else if (id == R.id.btclear) {
                input1.setText("");
                input2.setText("");
                input3.setText("");
                output1.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
                output5.setText("");


            }
        }
    }
}
